package com.redhat.developer.model.panel.common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Options {
    @JsonProperty("dataLinks")
    public List<String> dataLinks;
}
