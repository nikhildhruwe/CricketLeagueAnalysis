package com.bridgelabz.cricketleagueanalysis.adapter;

import com.bridgelabz.cricketleagueanalysis.dao.IPLAnalyserDAO;
import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.services.IPLAnalyser;

import java.util.Map;

public class IPLAdapterFactory {
    public static Map<String, IPLAnalyserDAO> getIPLData(IPLAnalyser.Player player, String csvFilePath)
            throws IPLAnalyserException {
        if (player.equals(IPLAnalyser.Player.BATSMAN))
            return new IPLMostRunsAdapter().loadIPLData(csvFilePath);
        if (player.equals(IPLAnalyser.Player.BOWLER))
            return new IPLMostWicketsAdapter().loadIPLData(csvFilePath);
        throw new IPLAnalyserException("Unknown Country", IPLAnalyserException.ExceptionType.INVALID_COUNTRY);
    }
}
