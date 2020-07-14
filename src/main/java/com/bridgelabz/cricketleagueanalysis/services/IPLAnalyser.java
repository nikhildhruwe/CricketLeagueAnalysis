package com.bridgelabz.cricketleagueanalysis.services;

import com.bridgelabz.cricketleagueanalysis.adapter.IPLAdapterFactory;
import com.bridgelabz.cricketleagueanalysis.dao.IPLAnalyserDAO;
import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;

import java.util.Map;


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

    public String getMostBattingAverages() {
        return null;
    }
}