package com.example.demo.Xml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlText;

public class CcyNm {
    @JacksonXmlProperty(isAttribute = true)
    private String lang = "LT";
    @JacksonXmlText
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
