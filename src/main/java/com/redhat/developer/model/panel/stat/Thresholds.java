package com.redhat.developer.model.panel.stat;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Thresholds {
    @JsonProperty("mode")
    public String mode = "absolute";

    @JsonProperty("steps")
    public List<Step> steps = generateDefault();

    private List<Step> generateDefault(){
        List<Step> s = new ArrayList<>();
        s.add(new Step("green", null));
        return s;
    }

}