package com.redhat.developer.model.panel;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GrafanaPanel {

    @JsonProperty("type")
    public String type;

    @JsonProperty("title")
    public String title;

    @JsonProperty("gridPos")
    public GrafanaGridPos gridPos;

    @JsonProperty("id")
    public int id;

    @JsonProperty("pluginVersion")
    public String pluginVersion =  "6.6.1";

    @JsonProperty("mode")
    public String mode;

    @JsonProperty("content")
    public String content;

    @JsonProperty("targets")
    public List<GrafanaTarget> targets;

    public GrafanaPanel(int id, String title, String type, GrafanaGridPos gridPos, List<GrafanaTarget> targets){
        this.id = id;
        this.title = title;
        this.type = type;
        this.gridPos = gridPos;
        this.targets = targets;
    }

}