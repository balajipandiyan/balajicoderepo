package com.reader.impl;
import com.model.Record;
import com.model.Records;
import com.reader.Reader;
import java.io.PrintStream;
import java.util.HashMap;

import java.io.File;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class XmlReader implements Reader {

    public HashMap<Integer, Record> readRecordsFromFile(final String fileLocation, final PrintStream printStream, final HashMap<Integer, Record> recordsMap) {

        try {
            File file = new File(fileLocation);
            JAXBContext jaxbContext = JAXBContext.newInstance(Records.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Records recds = (Records) unmarshaller.unmarshal(file);
            dumpDataToMapFromList(recds.getRecordList(), printStream, recordsMap);
        }catch(JAXBException ex){
            ex.printStackTrace();
        }

        return recordsMap;
    }


    private static void  dumpDataToMapFromList(final List<Record> recordList,  final PrintStream printStream, final HashMap<Integer, Record> recordsMap){
        if(recordList == null || recordList.size()<1){
            return;
        }

        recordList.forEach(record->{
            if(recordsMap.containsKey(record.getTransId())){
                printStream.println("Label=Duplicate_Transaction "+record.getTransId()+" | "+record.getDescription());
            }else{
                recordsMap.put(record.getTransId(),record);
            }
        });

    }
}
