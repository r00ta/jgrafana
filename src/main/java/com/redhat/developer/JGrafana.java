package com.redhat.developer;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redhat.developer.factories.GridPosFactory;
import com.redhat.developer.factories.PanelFactory;
import com.redhat.developer.model.GrafanaDashboard;
import com.redhat.developer.model.functions.ExprBuilder;
import com.redhat.developer.model.functions.GrafanaFunction;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.PanelType;

/**
 *  Java configurator to create standard grafana dashboards
 */
public class JGrafana implements IJGrafana{

    private GrafanaDashboard dashboard;

    /**
     * Parse a json grafana dashboard and returns the JGrafana object containing that dashboard.
     * @param dashboard
     * @return
     * @throws JsonProcessingException
     */
    public static IJGrafana parse(String dashboard) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        GrafanaDashboard dash = mapper.readValue(dashboard, GrafanaDashboard.class);
        for(int i = 0; i < dash.panels.size(); i++){
            GrafanaPanel p = dash.panels.get(i);
            p.id = i + 1;
            p.gridPos = GridPosFactory.calculateGridPosById(i + 1);
        }
        return new JGrafana(dash);
    }

    /**
     * Create a new JGrafana instance.
     * @param title: The title of your dashboard.
     */
    public JGrafana(String title){
        String uuid = UUID.randomUUID().toString();
        this.dashboard = new GrafanaDashboard(null, uuid, title);
    }

    /**
     * Create a new JGrafana dashboard from a grafana dashboard object.
     * @param dashboard: The grafana dashboard.
     */
    public JGrafana(GrafanaDashboard dashboard){
        this.dashboard = dashboard;
    }

    /**
     * Returns the dashboard.
     * @return: The GrafanaDashboard.
     */
    @Override
    public GrafanaDashboard getDashboard() {
        return dashboard;
    }

    /**
     * Adds a panel of a type to the dashboard.
     * @param type: The type of the panel to be added.
     * @param title: Title of the panel.
     * @param expr: Prompql expression of the panel.
     * @return: The grafana panel added to the dashboard.
     */
    @Override
    public GrafanaPanel addPanel(PanelType type, String title, String expr) {
        return addPanel(type, title, expr, null);
    }

    /**
     * Remove a panel by title.
     * @param title: The title of the panel to be removed.
     * @return: true if the panel has been remove, false otherwise.
     */
    @Override
    public boolean removePanelByTitle(String title){
        return this.dashboard.panels.removeIf(x -> x.title.equals(title));
    }

    /**
     * Adds a panel of a type to the dashboard.
     * @param type: The type of the panel to be added.
     * @param title: Title of the panel.
     * @param expr: Prompql expression of the panel.
     * @return: The grafana panel added to the dashboard.
     */
    @Override
    public GrafanaPanel addPanel(PanelType type, String title, String expr, Map<Integer, GrafanaFunction> functions) {
        int id = this.dashboard.panels.size() + 1;
        if (functions != null && functions.size() != 0){
            expr = ExprBuilder.apply(expr, functions);
        }
        GrafanaPanel panel = PanelFactory.CreatePanel(type, id, title, expr);
        this.dashboard.panels.add(panel);
        return panel;
    }

    /**
     * Gets a panel by title.
     * @param title: The panel title to be retrieved.
     * @return: The panel.
     */
    @Override
    public GrafanaPanel getPanelByTitle(String title) throws NoSuchElementException {
        Optional<GrafanaPanel> panel = this.dashboard.panels.stream().filter(x -> x.title.equals(title)).findFirst();
        if (!panel.isPresent()){
            throw new NoSuchElementException(String.format("There is no panel with title \"%s\"", title));
        }
        return panel.get();
    }

    /**
     * Writes the dashboard to a file.
     * @param file: The file to be written.
     * @throws IOException
     */
    @Override
    public void writeToFile(File file) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writer(new DefaultPrettyPrinter());
        mapper.writeValue(file, this.dashboard);
    }

    /**
     * Serialize the dashboard.
     * @return: The serialized json dashboard.
     * @throws IOException
     */
    @Override
    public String serialize() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this.dashboard);
    }
}
