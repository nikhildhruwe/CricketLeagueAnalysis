package com.bridgelabz.cricketleagueanalysis.dao;

import com.bridgelabz.cricketleagueanalysis.model.IPLMostRunsData;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostWicketsData;
import com.bridgelabz.cricketleagueanalysis.services.IPLAnalyser;

public class IPLAnalyserDAO {

    public String player;
    public double averages;
    public int fours;
    public int sixes;
    public int runs;
    public double strikeRates;
    public int fourWickets;
    public int fiveWickets;
    public double economyRates;
    public int wickets;

    public IPLAnalyserDAO(IPLMostRunsData iplMostRunsData)
    {
        player= iplMostRunsData.player;
        averages=iplMostRunsData.averages;
        strikeRates=iplMostRunsData.strikeRates;
        fours=iplMostRunsData.fours;
        sixes=iplMostRunsData.sixes;
        runs=iplMostRunsData.runs;
    }

    public IPLAnalyserDAO(IPLMostWicketsData iplMostWicketsData)
    {
        player=iplMostWicketsData.player;
        strikeRates=iplMostWicketsData.strikeRates;
        economyRates=iplMostWicketsData.economyRates;
        fourWickets=iplMostWicketsData.fourWickets;
        fiveWickets=iplMostWicketsData.fiveWickets;
        averages=iplMostWicketsData.averages;
        wickets=iplMostWicketsData.wickets;
    }

    public Object getIPLDTO(IPLAnalyser.Player player)
    {
        if (player.equals(IPLAnalyser.Player.BATSMAN))
            return new IPLMostRunsData(this.player, averages, strikeRates, fours, sixes, runs);
        return new IPLMostWicketsData(this.player, averages, strikeRates, fourWickets, fiveWickets, economyRates, wickets);
    }
}
