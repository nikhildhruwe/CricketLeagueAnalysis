package com.bridgelabz.cricketleagueanalysis.services;

import com.bridgelabz.cricketleagueanalysis.adapter.IPLAdapterFactory;
import com.bridgelabz.cricketleagueanalysis.dao.IPLAnalyserDAO;
import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;

import static java.util.stream.Collectors.toCollection;


public class IPLAnalyser {
    public Player player;


    public enum Player {BATSMAN, BOWLER}
    Map<String, IPLAnalyserDAO> iplMap;

    public IPLAnalyser(Player player) {
        this.player = player;
    }

    public int loadIPLData(Player player, String csvFilePath) throws IPLAnalyserException {
        iplMap = IPLAdapterFactory.getIPLData(player, csvFilePath);
        return iplMap.size();
    }

    public String getMostBattingAverages() throws IPLAnalyserException {
        if (iplMap == null || iplMap.size() == 0) {
            throw new IPLAnalyserException("No iplData"
                    , IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        }
        Comparator<IPLAnalyserDAO> iplComparator = Comparator.comparing(iplData -> iplData.averages);
        ArrayList iplDTO = iplMap.values().stream().sorted(iplComparator.reversed())
                .map(iplAnalyserDAO -> iplAnalyserDAO.getIPLDTO(player))
                .collect(toCollection(ArrayList::new));
        String sortedIPLJson = new Gson().toJson(iplDTO);
        return sortedIPLJson;
    }
}