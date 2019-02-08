package com.reader.impl;

import com.model.Record;
import com.reader.Reader;

import java.io.*;
import java.util.HashMap;

public class CSVReader implements Reader {

    public HashMap<Integer,Record> readRecordsFromFile(final String fileLocation, final PrintStream printStream, final HashMap<Integer, Record> recordsMap){

        BufferedReader br = null;
        try {
            String fileLine = "";

            br = new BufferedReader(new FileReader(fileLocation));
            int lineCount=0;
            while ((fileLine = br.readLine()) != null ) {
               ++lineCount;
               if(lineCount<2){
                  continue;
               }

                String[] record = fileLine.split(",");

                if(record!= null && record.length>5){
                    Record lineRecord = new Record();
                    lineRecord.setTransId(Integer.valueOf(record[0]));
                    lineRecord.setAcctNum(record[1]);
                    lineRecord.setDescription(record[2]);
                    lineRecord.setStartBalance(Float.valueOf(record[3]));
                    lineRecord.setMutation(Float.valueOf(record[4]));
                    lineRecord.setEndBalance(Float.valueOf(record[5]));
                    if(recordsMap.containsKey(lineRecord.getTransId())){
                       printStream.println("Label=Duplicate_Transaction  "+lineRecord.getTransId()+" | "+lineRecord.getDescription());
                    }else{
                        recordsMap.put(lineRecord.getTransId(),lineRecord);
                    }
                }else{
                    printStream.println("Label=Invalid_Record @ csv file line num "+lineCount);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

      return recordsMap;
    }

}
