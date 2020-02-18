package com.redhat.developer;

import java.io.File;
import java.util.UUID;

import com.redhat.developer.factories.PanelFactory;
import com.redhat.developer.model.GrafanaDashboard;
import com.redhat.developer.model.GrafanaDashboardMeta;
import com.redhat.developer.model.panel.PanelType;

public class JGrafana implements IJGrafana{

    private GrafanaDashboard dashboard;

    @Override
    public void parse(String dashboard) {
    }

    @Override
    public void parse(File dashboardPath) {
    }

    @Override
    public void store(File dashboardPath){
    }

    @Override
    public String initDashboard(int folderId, boolean overwrite, String title) {
        this.dashboard = new GrafanaDashboard(folderId, overwrite);
        String uuid = UUID.randomUUID().toString();
        this.dashboard.meta = new GrafanaDashboardMeta(null, uuid, title);
        return uuid;
    }

    @Override
    public GrafanaDashboard getDashboard() {
        return dashboard;
    }

    @Override
    public void addPanel(PanelType type, String title, String expr) {
        int id = this.dashboard.meta.panels.size() + 1;
        this.dashboard.meta.panels.add(PanelFactory.CreatePanel(type, id, title, expr));
    }
}
