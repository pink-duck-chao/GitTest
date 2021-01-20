package com.bistu.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class DataObj {
    private String sn;
    private BigDecimal meterFlow;
    private BigDecimal meterSpeed;
    private BigDecimal meterTotal;
    private Date date;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public BigDecimal getMeterFlow() {
        return meterFlow;
    }

    public void setMeterFlow(BigDecimal meterFlow) {
        this.meterFlow = meterFlow;
    }

    public BigDecimal getMeterSpeed() {
        return meterSpeed;
    }

    public void setMeterSpeed(BigDecimal meterSpeed) {
        this.meterSpeed = meterSpeed;
    }

    public BigDecimal getMeterTotal() {
        return meterTotal;
    }

    public void setMeterTotal(BigDecimal meterTotal) {
        this.meterTotal = meterTotal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DataObj() {
    }

    public DataObj(String sn, BigDecimal meterFlow, BigDecimal meterSpeed, BigDecimal meterTotal) {
        this.sn = sn;
        this.meterFlow = meterFlow;
        this.meterSpeed = meterSpeed;
        this.meterTotal = meterTotal;

    }
}
