package com.redhat.developer;

import java.io.File;

import com.redhat.developer.model.GrafanaDashboard;
import com.redhat.developer.model.panel.PanelType;

public interface IJGrafana {

    void parse(String dashboard);

    void parse(File dashboardPath);

    void store(File dashboardPath);

    String initDashboard(int folderId, boolean overwrite, String title);

    GrafanaDashboard getDashboard();

    void addPanel(PanelType type, String title, String expr);
}
