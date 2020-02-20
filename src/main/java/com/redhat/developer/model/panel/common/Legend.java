package com.redhat.developer.model.panel.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Legend {
    @JsonProperty("avg")
    public boolean avg;

    @JsonProperty("legend")
    public boolean legend;

    @JsonProperty("current")
    public boolean current;

    @JsonProperty("max")
    public boolean max;

    @JsonProperty("min")
    public boolean min;

    @JsonProperty("show")
    public boolean show;

    @JsonProperty("total")
    public boolean total;

    @JsonProperty("values")
    public boolean values;
}
