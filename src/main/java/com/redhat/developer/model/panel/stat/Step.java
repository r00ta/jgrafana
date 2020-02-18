package com.redhat.developer.model.panel.stat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Step {

    @JsonProperty("color")
    public String color;

    @JsonProperty("value")
    public Double value = null;

    public Step(String color, Double value){
        this.color = color;
        this.value = value;
    }
}
