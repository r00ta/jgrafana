package com.redhat.developer.model.panel.table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

public class TableSort {
    @JsonProperty("col")
    public int col = 0;

    @JsonProperty("desc")
    public boolean desc;
}