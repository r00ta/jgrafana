package com.redhat.developer.model.panel;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrafanaTarget {
    @JsonProperty("expr")
    public String expr;

    @JsonProperty("format")
    public String format;

    @JsonProperty("intervalFactor")
    public int intervalFactor = 2;

    @JsonProperty("refId")
    public String refId = "A";

    public GrafanaTarget(String expr, String format){
        this.expr = expr;
        this.format = format;
    }
}