import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.services.IPLAnalyser;
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
}
