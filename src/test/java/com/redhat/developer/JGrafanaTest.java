package com.redhat.developer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.redhat.developer.model.panel.PanelType;
import org.junit.jupiter.api.Test;

public class JGrafanaTest {

    @Test
    public void GivenANewContext_WhenANewJGrafanaObjectIsCreated_ThenTheDefaultObjectIsCreated() {
        JGrafana grafanaObj = new JGrafana();
        grafanaObj.initDashboard(0, false, "My Dashboard");
        assertEquals(0, grafanaObj.getDashboard().folderId);
        assertEquals(false, grafanaObj.getDashboard().overwrite);
        assertEquals(0, grafanaObj.getDashboard().meta.panels.size());
    }

    @Test
    public void GivenANewContext_WhenANewGraphPanelsAreAdded_ThenThePanelsAreInTheCorrectPositions() {
        JGrafana grafanaObj = new JGrafana();
        grafanaObj.initDashboard(0, false, "My Dashboard");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 1", "test");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "test");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 3", "test");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 4", "test");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 5", "test");

        assertEquals(0, grafanaObj.getDashboard().meta.panels.get(0).gridPos.x);
        assertEquals(0, grafanaObj.getDashboard().meta.panels.get(0).gridPos.y);

        assertEquals(12, grafanaObj.getDashboard().meta.panels.get(1).gridPos.x);
        assertEquals(0, grafanaObj.getDashboard().meta.panels.get(1).gridPos.y);

        assertEquals(0, grafanaObj.getDashboard().meta.panels.get(2).gridPos.x);
        assertEquals(8, grafanaObj.getDashboard().meta.panels.get(2).gridPos.y);

        assertEquals(12, grafanaObj.getDashboard().meta.panels.get(3).gridPos.x);
        assertEquals(8, grafanaObj.getDashboard().meta.panels.get(3).gridPos.y);

        assertEquals(0, grafanaObj.getDashboard().meta.panels.get(4).gridPos.x);
        assertEquals(16, grafanaObj.getDashboard().meta.panels.get(4).gridPos.y);
    }
}
