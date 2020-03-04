package com.redhat.developer;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redhat.developer.model.GrafanaDashboard;
import com.redhat.developer.model.functions.GrafanaFunction;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.PanelType;

public interface IJGrafana {
    GrafanaDashboard getDashboard();

    GrafanaPanel addPanel(PanelType type, String title, String expr);

    GrafanaPanel addPanel(PanelType type, String title, String expr, HashMap<Integer, GrafanaFunction> functions);

    boolean removePanelByTitle(String title);

    GrafanaPanel getPanelByTitle(String title);

    String serialize() throws IOException;

    void writeToFile(File file) throws IOException;
}
