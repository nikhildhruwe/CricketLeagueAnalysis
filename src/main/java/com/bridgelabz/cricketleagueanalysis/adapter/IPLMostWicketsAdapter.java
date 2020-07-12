package com.bridgelabz.cricketleagueanalysis.adapter;

import com.bridgelabz.cricketleagueanalysis.dao.IPLAnalyserDAO;
import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostWicketsData;

import java.util.Map;

public class IPLMostWicketsAdapter extends IPLAdapter {
    public Map<String, IPLAnalyserDAO> loadIPLData(String csvFilePath) throws IPLAnalyserException {
        Map<String, IPLAnalyserDAO> IPLMap = super.loadIPLData(IPLMostWicketsData.class, csvFilePath);
        return IPLMap;
    }
}
