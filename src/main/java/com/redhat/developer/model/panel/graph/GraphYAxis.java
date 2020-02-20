package com.redhat.developer.model.panel.graph;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphYAxis {

    @JsonProperty("align")
    public boolean align;

    @JsonProperty("alignLevel")
    public String alignLevel;
}
