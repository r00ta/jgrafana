package com.redhat.developer.model.templating;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrafanaTemplateOption {
    @JsonProperty("selected")
    public boolean selected;

    @JsonProperty("text")
    public String text;

    @JsonProperty("value")
    public String value;
}