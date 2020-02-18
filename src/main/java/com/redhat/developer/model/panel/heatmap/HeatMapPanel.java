package com.redhat.developer.model.panel.heatmap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.developer.model.panel.GrafanaGridPos;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.GrafanaTarget;

public class HeatMapPanel extends GrafanaPanel {

    @JsonProperty("color")
    public PanelColor color = new PanelColor();

    @JsonProperty("dataFormat")
    public String dataFormat = "tsbuckets";

    @JsonProperty("reverseYBuckets")
    public boolean reverseYBuckets = false;

    @JsonProperty("hideZeroBuckets")
    public boolean hideZeroBuckets = false;

    @JsonProperty("highlightCards")
    public boolean highlighCards = true;

    @JsonProperty("yAxis")
    public YAxis yAxis = new YAxis();

    @JsonProperty("yBucketBound")
    public String yBucketBound = "auto";

    @JsonProperty("yBucketNumber")
    public String yBucketNumber = null;

    @JsonProperty("yBucketSize")
    public String yBucketSize = null;

    public HeatMapPanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "heatmap", gridPos, targets);
    }
}
