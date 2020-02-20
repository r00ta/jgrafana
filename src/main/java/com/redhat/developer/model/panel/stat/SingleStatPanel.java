package com.redhat.developer.model.panel.stat;

import java.util.List;

import com.redhat.developer.model.panel.GrafanaGridPos;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.GrafanaTarget;

public class SingleStatPanel extends GrafanaPanel {

    public SingleStatPanel(){
        super();
    }

    public SingleStatPanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "singleStat", gridPos, targets);
    }
}
