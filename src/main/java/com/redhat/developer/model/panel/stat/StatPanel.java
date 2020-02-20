package com.redhat.developer.model.panel.stat;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.developer.model.panel.GrafanaGridPos;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.GrafanaTarget;
import com.redhat.developer.model.panel.stat.StatOptions;

public class StatPanel extends GrafanaPanel {
    @JsonProperty("options")
    public StatOptions options = new StatOptions();

    public StatPanel(){
        super();
    }

    public StatPanel(int id, String title , GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "stat", gridPos, targets);
            }
}
