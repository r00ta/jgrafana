package com.redhat.developer.model.panel;

import java.util.List;

public class StatPanel extends GrafanaPanel {

    public StatPanel(int id, String title , GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "stat", gridPos, targets);
            }
            }
