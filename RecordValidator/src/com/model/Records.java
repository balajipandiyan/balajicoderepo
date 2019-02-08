package com.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name="records")
@XmlAccessorType(XmlAccessType.FIELD)
public class Records {
    @XmlElement(name = "record")
    private List<Record> recordList;

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }
}
