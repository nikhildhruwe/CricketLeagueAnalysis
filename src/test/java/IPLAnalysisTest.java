import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.services.IPLAnalyser;
import org.junit.Assert;
import org.junit.Test;


public class IPLAnalysisTest {

    private static final String IPL_MOST_RUNS_CSV_FILE_PATH = "./src/test/resources/IPL2019FactsheetMostRuns.csv";

    @Test
    public void givenIplMostRunsCSVFile_WhenProper_ShouldReturnRecordNumbers() throws IPLAnalyserException {
        IPLAnalyser iplAnalyser = new IPLAnalyser(IPLAnalyser.Player.BATSMAN);
        int iplRecordCount = iplAnalyser.loadIPLData(IPLAnalyser.Player.BATSMAN, IPL_MOST_RUNS_CSV_FILE_PATH);
        Assert.assertEquals(1, iplRecordCount);

    }
}
