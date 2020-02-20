package com.redhat.developer.model.panel.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class XAxis {
    @JsonProperty("buckets")
    public String buckets;

    @JsonProperty("mode")
    public String mode;

    @JsonProperty("name")
    public String name;

    @JsonProperty("show")
    public boolean show;

    @JsonProperty("values")
    public List<Double> values;
}