package com.main;

import com.model.Record;
import com.reader.impl.CSVReader;
import com.reader.impl.XmlReader;

import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RecordValidator {

    public static  PrintStream log;

    public static final  String DATA_DIR = System.getProperty("user.dir")+"\\data\\";


    public static void main(String args[]){

        HashMap<Integer, Record> recordsMap = new HashMap<Integer, Record>();

        for(int i=0;i<args.length;i++) {

            String filename = args[i];

            if (filename != null && !filename.isEmpty()) {
                int index = filename.lastIndexOf(".");
                String fileExt = filename.substring(index);

                com.reader.Reader reader = getFileReader(fileExt);
                if(reader != null) {
                    reader.readRecordsFromFile(DATA_DIR + filename, log, recordsMap);
                }

            }
        }
         recordsMap.values().stream().filter(rec-> (rec.getStartBalance()+rec.getMutation())== rec.getEndBalance()).collect(Collectors.toList()).forEach(record -> {
                     log.println("Label=IncorrectEndBalance    "+record.getTransId()+" | "+record.getDescription());
         }
         );
    }

    static com.reader.Reader getFileReader(final String fileType){
        com.reader.Reader reader = null;
        if(fileType == null){
           return reader;
        }

        if(".csv".equalsIgnoreCase(fileType)){
             reader =   new CSVReader();

        }else if(".xml".equalsIgnoreCase(fileType)) {
            reader = new XmlReader();
        }
        return  reader;
    }

    static{
        try{
            log = new PrintStream(new File(System.getProperty("user.dir")+"/log/recordsReport_"+System.currentTimeMillis()+".txt"));
        }catch (Exception ex){
          ex.printStackTrace();

        }
    }
}
