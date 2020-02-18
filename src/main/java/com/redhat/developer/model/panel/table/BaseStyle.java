package com.redhat.developer.model.panel.table;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BaseStyle {

    @JsonProperty("alias")
    public String alias;

    @JsonProperty("align")
    public String align;

    @JsonProperty("pattern")
    public String pattern;

    @JsonProperty("type")
    public String type;

    public BaseStyle(String alias, String type, String pattern, String align){
        this.alias = alias;
        this.type = type;
        this.pattern = pattern;
        this.align = align;
    }
}