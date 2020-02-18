package com.redhat.developer.model.panel;

import java.util.List;

public class HeatMapPanel extends GrafanaPanel {

    public HeatMapPanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "heatmap", gridPos, targets);
    }
}
