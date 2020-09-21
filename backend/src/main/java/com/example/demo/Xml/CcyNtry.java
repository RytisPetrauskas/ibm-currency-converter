package com.example.demo.Xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public class CcyNtry {
    @JsonProperty("Ccy")
    private String Ccy;

    @JsonProperty("CcyNm")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<CcyNm> CcyNm;

    @JsonProperty("CcyNbr")
    private String CcyNbr;
    @JsonProperty("CcyMnrUnts")
    private int CcyMnrUnts;

    public String getCcy() {
        return Ccy;
    }

    public void setCcy(String ccy) {
        this.Ccy = ccy;
    }

    public String getCcyNbr() {
        return CcyNbr;
    }

    public void setCcyNbr(String ccyNbr) {
        CcyNbr = ccyNbr;
    }

    public int getCcyMnrUnts() {
        return CcyMnrUnts;
    }

    public void setCcyMnrUnts(int ccyMnrUnts) {
        CcyMnrUnts = ccyMnrUnts;
    }

    public List<CcyNm> getCcyNm() {
        return CcyNm;
    }

    public void setCcyNm(List<CcyNm> ccyNm) {
        CcyNm = ccyNm;
    }
}
