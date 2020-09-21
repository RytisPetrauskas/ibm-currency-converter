package com.example.demo.Xml;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CcyAmt {
    @JsonProperty("Ccy")
    private String ccy;
    @JsonProperty("Amt")
    private Double amt;

    public String getCcy() {
        return ccy;
    }

    public void setCcy(String ccy) {
        this.ccy = ccy;
    }

    public Double getAmt() {
        return amt;
    }

    public void setAmt(Double amt) {
        this.amt = amt;
    }
}
