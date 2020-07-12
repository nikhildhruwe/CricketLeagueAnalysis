package com.bridgelabz.cricketleagueanalysis.exception;

public class IPLAnalyserException extends Exception{
    public enum ExceptionType {
        IPL_FILE_PROBLEM, INCORRECT_CSV_INPUT, INVALID_COUNTRY;
    }

    public ExceptionType type;

    public IPLAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

    public IPLAnalyserException(String message, String name) {
        super(message);
        this.type = ExceptionType.valueOf(name);
    }
}