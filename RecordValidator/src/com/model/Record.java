package com.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Record")
@XmlAccessorType(XmlAccessType.FIELD)
public class Record {

    @XmlAttribute(name = "reference")
    private Integer transId;
    @XmlElement(name = "accountNumber")
    private String acctNum;
    @XmlElement(name = "description")
    private String description;
    @XmlElement(name = "startBalance")
    private float startBalance;
    @XmlElement(name = "mutation")
    private float mutation;
    @XmlElement(name = "endBalance")
    private float endBalance;

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getAcctNum() {
        return acctNum;
    }

    public void setAcctNum(String acctNum) {
        this.acctNum = acctNum;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getStartBalance() {
        return startBalance;
    }

    public void setStartBalance(float startBalance) {
        this.startBalance = startBalance;
    }

    public float getMutation() {
        return mutation;
    }

    public void setMutation(float mutation) {
        this.mutation = mutation;
    }

    public float getEndBalance() {
        return endBalance;
    }

    public void setEndBalance(float endBalance) {
        this.endBalance = endBalance;
    }
}
