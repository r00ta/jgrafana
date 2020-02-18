package com.redhat.developer.model.panel.heatmap;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

public class YAxis {
    @JsonProperty("decimals")
    public String decimals = null;

    @JsonProperty("format")
    public String format = "ns";

    @JsonProperty("logBase")
    public int logBase = 1;

    @JsonProperty("max")
    public String max = null;

    @JsonProperty("min")
    public String min = null;

    @JsonProperty("show")
    public boolean show = true;

    @JsonProperty("splitFactor")
    public String splitFactor = null;
}