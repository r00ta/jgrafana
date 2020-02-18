package com.redhat.developer.model.panel;

import java.util.List;

public class SingleStatPanel extends GrafanaPanel {

    public SingleStatPanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "singleStat", gridPos, targets);
    }
}
