package com.bridgelabz.cricketleagueanalysis.dao;

import com.bridgelabz.cricketleagueanalysis.model.IPLMostRunsData;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostWicketsData;

public class IPLAnalyserDAO {
    public int numberOfFiveWickets;
    public int numberOfFoursWicket;
    public Double economy;
    public int wickets;
    public int position;
    public String playerName;
    public Double strikeRate;
    public Double batsmanAverage;
    public Double bowlerAverage;
    public int numberOf6s;
    public int numberOf4s;
    public int numberOfRuns;

    public IPLAnalyserDAO(IPLMostRunsData iplBatsmanData) {
        position = iplBatsmanData.position;
        playerName = iplBatsmanData.playerName;
        strikeRate = iplBatsmanData.strikeRate;
        batsmanAverage = iplBatsmanData.average;
        numberOf4s = iplBatsmanData.numberOfFours;
        numberOf6s = iplBatsmanData.numberOfSix;
        numberOfRuns = iplBatsmanData.runs;
    }

    public IPLAnalyserDAO(IPLMostWicketsData iplBowlerData) {
        playerName = iplBowlerData.playerName;
        bowlerAverage = iplBowlerData.average;
        strikeRate = iplBowlerData.strikeRate;
        wickets = iplBowlerData.wickets;
        economy = iplBowlerData.economy;
        numberOfFoursWicket = iplBowlerData.numberOfFoursWickets;
        numberOfFiveWickets = iplBowlerData.numberOfFifthWickets;
    }
}
