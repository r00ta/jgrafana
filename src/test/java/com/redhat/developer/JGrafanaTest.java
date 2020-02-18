package com.redhat.developer;

import java.awt.List;
import java.io.IOException;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.redhat.developer.model.panel.PanelType;
import org.junit.jupiter.api.Test;

public class JGrafanaTest {

    @Test
    public void GivenANewContext_WhenANewJGrafanaObjectIsCreated_ThenTheDefaultObjectIsCreated() {
        // Arrange
        JGrafana grafanaObj = new JGrafana("My Dashboard");

        // Assert
        assertEquals(0, grafanaObj.getDashboard().panels.size());
    }

    @Test
    public void GivenANewContext_WhenANewGraphPanelsAreAdded_ThenThePanelsAreInTheCorrectPositions() {
        // Arrange
        JGrafana grafanaObj = new JGrafana("My Dashboard");

        // Act
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 1", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 3", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 4", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 5", "api_http_response_code{handler=\"world\"}");

        // Assert
        assertEquals(0, grafanaObj.getDashboard().panels.get(0).gridPos.x);
        assertEquals(0, grafanaObj.getDashboard().panels.get(0).gridPos.y);

        assertEquals(12, grafanaObj.getDashboard().panels.get(1).gridPos.x);
        assertEquals(0, grafanaObj.getDashboard().panels.get(1).gridPos.y);

        assertEquals(0, grafanaObj.getDashboard().panels.get(2).gridPos.x);
        assertEquals(8, grafanaObj.getDashboard().panels.get(2).gridPos.y);

        assertEquals(12, grafanaObj.getDashboard().panels.get(3).gridPos.x);
        assertEquals(8, grafanaObj.getDashboard().panels.get(3).gridPos.y);

        assertEquals(0, grafanaObj.getDashboard().panels.get(4).gridPos.x);
        assertEquals(16, grafanaObj.getDashboard().panels.get(4).gridPos.y);
    }

    @Test
    public void GivenADashboard_WhenAPanelIsDeleted_ThenTheDashboardIsCorrect() {
        // Arrange
        JGrafana grafanaObj = new JGrafana("My Dashboard");

        // Act
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 1", "api_http_response_code{handler=\"world\"}");
        grafanaObj.removePanelByTitle("My Graph 1");

        // Assert
        assertEquals(0, grafanaObj.getDashboard().panels.size());
    }

    @Test
    public void GivenADashboardWithManyPanels_WhenAPanelIsDeleted_ThenTheDashboardIsCorrect() {
        // Arrange
        JGrafana grafanaObj = new JGrafana("My Dashboard");

        // Act
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 1", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 3", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 4", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 5", "api_http_response_code{handler=\"world\"}");
        grafanaObj.removePanelByTitle("My Graph 3");
        grafanaObj.removePanelByTitle("My Graph 5");

        // Assert
        assertEquals(3, grafanaObj.getDashboard().panels.size());
        assertEquals(true, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 1"));
        assertEquals(true, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 2"));
        assertEquals(true, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 4"));
        assertEquals(false, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 3"));
    }

    @Test
    public void GivenADashboardWithManyPanelsWithSameTitle_WhenAPanelIsDeleted_ThenAllThePanelsWithThatNameAreRemoved(){
        JGrafana grafanaObj = new JGrafana("My Dashboard");

        // Act
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 1", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 2", "api_http_response_code{handler=\"world\"}");
        grafanaObj.addPanel(PanelType.GRAPH, "My Graph 3", "api_http_response_code{handler=\"world\"}");
        grafanaObj.removePanelByTitle("My Graph 2");

        // Assert
        assertEquals(2, grafanaObj.getDashboard().panels.size());
        assertEquals(true, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 1"));
        assertEquals(false, grafanaObj.getDashboard().panels.stream().anyMatch(x -> x.title == "My Graph 2"));
    }
}
