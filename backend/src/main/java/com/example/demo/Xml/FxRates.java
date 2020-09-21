package com.example.demo.Xml;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class FxRates {
    @JsonProperty("FxRate")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<FxRate> values = new ArrayList<>();

    public List<FxRate> getValues() {
        return values;
    }

    public void setValues(List<FxRate> values) {
        this.values = values;
    }
}
