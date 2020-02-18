package com.redhat.developer.model.panel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GraphPanel extends GrafanaPanel {

    @JsonProperty("bars")
    public boolean bars = false;

    @JsonProperty("dashes")
    public boolean dashes = false;

    @JsonProperty("fill")
    public int fill = 1;

    @JsonProperty("fillGradient")
    public int fillGradient = 0;

    @JsonProperty("hiddenSeries")
    public boolean hiddenSeries = false;

    @JsonProperty("linewidth")
    public int linewidth = 1;

    @JsonProperty("pointradius")
    public int pointRadius = 2;

    @JsonProperty("points")
    public boolean points = false;

    @JsonProperty("percentage")
    public boolean percentage = false;

    @JsonProperty("renderer")
    public String renderer = "flot";

    @JsonProperty("spaceLength")
    public int spaceLength = 10;

    @JsonProperty("stack")
    public boolean stack = false;

    @JsonProperty("steppedLine")
    public boolean steppedLine = false;

    @JsonProperty("lines")
    public boolean lines = true;

    public GraphPanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "graph", gridPos, targets);
    }
}
