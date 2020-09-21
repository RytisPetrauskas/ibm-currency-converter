package com.example.demo.Xml;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;


public class FxRate {
    @JsonProperty("Tp")
    private String Tp;
    @JsonProperty("Dt")
    private String Dt;
    @JsonProperty("CcyAmt")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CcyAmt> ccyAmts = new ArrayList<>();

    public String getTp() {
        return Tp;
    }

    public void setTp(String tp) {
        Tp = tp;
    }

    public String getDt() {
        return Dt;
    }

    public void setDt(String dt) {
        Dt = dt;
    }

    public List<CcyAmt> getCcyAmts() {
        return ccyAmts;
    }

    public void setCcyAmts(List<CcyAmt> ccyAmts) {
        this.ccyAmts = ccyAmts;
    }
}
