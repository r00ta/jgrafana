package com.redhat.developer.model.panel.stat;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatOptions {
    @JsonProperty("colorMode")
    public String colorMode = "value";

    @JsonProperty("fieldOptions")
    public FieldOptions fieldOptions = new FieldOptions();

    @JsonProperty("graphMode")
    public String graphMode = "area";

    @JsonProperty("justifyMode")
    public String justifyMode = "auto";

    @JsonProperty("orientation")
    public String orientation = "auto";

}