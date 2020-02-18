package com.redhat.developer.model.panel;

import java.util.List;

public class TablePanel extends GrafanaPanel {

    public TablePanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "table", gridPos, targets);
    }
}
