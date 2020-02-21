package com.redhat.developer.model.panel.table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableSort {
    @JsonProperty("col")
    public int col = 0;

    @JsonProperty("desc")
    public boolean desc;
}