package com.redhat.developer.model.panel;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.developer.model.panel.stat.StatOptions;

public class StatPanel extends GrafanaPanel {
    @JsonProperty("options")
    public StatOptions options = new StatOptions();

    public StatPanel(int id, String title , GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "stat", gridPos, targets);
            }
}
