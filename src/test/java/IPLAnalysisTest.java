import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostRunsData;
import com.bridgelabz.cricketleagueanalysis.services.IPLAnalyser;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class IPLAnalysisTest {

    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/Day16 Data_01 IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIplMostRunsCSVFile_WhenProper_ShouldReturnRecordNumbers() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
            int iplRecordCount = iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_MOST_RUNS_CSV_FILE_PATH);
            Assert.assertEquals(100, iplRecordCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //UC1
    @Test
    public void givenIPLMostRunsCSVData_WhenSortedWithBattingAverages_ShouldReturnInDecreasingOrder() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
            iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_MOST_RUNS_CSV_FILE_PATH);
            String mostBattingAverages = iplAnalyser.getMostBattingAverages();
             IPLMostRunsData[] iplMostRunsData= new Gson().fromJson(mostBattingAverages, IPLMostRunsData[].class);
            Assert.assertEquals("MS Dhoni", iplMostRunsData[0].player);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
            System.out.println(e.getMessage());
        }
    }

    //UC2
    @Test
    public void givenIPLMostRunsCSVData_WhenSortedWithStrikingRAte_ShouldReturnInDecreasingOrder() {
        try {
            IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
            iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_MOST_RUNS_CSV_FILE_PATH);
            String mostStrikingRates = iplAnalyser.getSortedOrderByStrikingRates();
            IPLMostRunsData[] iplMostRunsData= new Gson().fromJson(mostStrikingRates, IPLMostRunsData[].class);
            Assert.assertEquals("Ishant Sharma", iplMostRunsData[0].player);
        } catch (IPLAnalyserException e) {
            Assert.assertEquals(IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM, e.type);
            System.out.println(e.getMessage());
        }
    }
}
