package com.redhat.developer.model.panel.stat;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Defaults {
    @JsonProperty("mappings")
    public List<String> mappings = new ArrayList<>();

    @JsonProperty("thresholds")
    public Thresholds thresholds = new Thresholds();
}