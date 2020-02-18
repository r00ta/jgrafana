package com.redhat.developer;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redhat.developer.model.GrafanaDashboard;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.PanelType;

public interface IJGrafana {

    IJGrafana parse(String dashboard) throws JsonProcessingException;

    IJGrafana parse(File dashboardPath) throws IOException;

    GrafanaDashboard getDashboard();

    GrafanaPanel addPanel(PanelType type, String title, String expr);

    boolean removePanelByTitle(String title);

    GrafanaPanel getPanelByTitle(String title);

    String serialize() throws IOException;

    void writeToFile(File file) throws IOException;
}
