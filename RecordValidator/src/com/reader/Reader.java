package com.reader;

import com.model.Record;

import java.io.PrintStream;
import java.util.HashMap;

public interface Reader {
    public HashMap<Integer,Record> readRecordsFromFile(final String fileLocation, final PrintStream printStream, final HashMap<Integer, Record> recordsMap);
}
