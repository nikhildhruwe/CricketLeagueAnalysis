package com.bridgelabz.cricketleagueanalysis.adapter;

import com.bridgelabz.cricketleagueanalysis.dao.IPLAnalyserDAO;
import com.bridgelabz.cricketleagueanalysis.exception.IPLAnalyserException;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostRunsData;
import com.bridgelabz.cricketleagueanalysis.model.IPLMostWicketsData;
import com.bridgelabz.csvjar.utility.CSVBuilderException;
import com.bridgelabz.csvjar.utility.CSVBuilderFactory;
import com.bridgelabz.csvjar.utility.ICSVBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public abstract class IPLAdapter {
    public <E> Map<String, IPLAnalyserDAO> loadIPLData(Class<E> csvClass, String iplFilePath) throws IPLAnalyserException {
        Map<String, IPLAnalyserDAO> iplMap = new HashMap<>();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(iplFilePath));
            ICSVBuilder csvBuilder = CSVBuilderFactory.craeteCSVBuilder();
            Iterator<E> iplIterator = csvBuilder.getCSVFileIterator(reader, csvClass);
            Iterable<E> iplIterable = () -> iplIterator;
            if (csvClass.getSimpleName().equals("IPLMostRunsData")) {
                StreamSupport.stream(iplIterable.spliterator(), false)
                        .map(IPLMostRunsData.class::cast)
                        .forEach(iplData -> iplMap.put(iplData.playerName, new IPLAnalyserDAO(iplData)));
            }
            if (csvClass.getSimpleName().equals("IPLMostWicketsData")) {
                StreamSupport.stream(iplIterable.spliterator(), false)
                        .map(IPLMostWicketsData.class::cast)
                        .forEach(iplData -> iplMap.put(iplData.playerName, new IPLAnalyserDAO(iplData)));
            }
            return iplMap;
        } catch (IOException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.IPL_FILE_PROBLEM);
        } catch (RuntimeException e) {
            throw new IPLAnalyserException(e.getMessage(),
                    IPLAnalyserException.ExceptionType.INCORRECT_CSV_INPUT);
        } catch (CSVBuilderException e) {
            throw new IPLAnalyserException(e.getMessage(), e.type.name());
        }
    }
}
