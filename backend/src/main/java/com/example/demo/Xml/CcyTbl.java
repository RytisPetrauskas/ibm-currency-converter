package com.example.demo.Xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class CcyTbl {
    @JsonProperty("CcyNtry")
    @JacksonXmlElementWrapper(useWrapping = false)
    List<CcyNtry> values = new ArrayList<>();

    public List<CcyNtry> getValues() {
        return values;
    }

    public void setValues(List<CcyNtry> values) {
        this.values = values;
    }
}
