package com.redhat.developer.factories;

import com.redhat.developer.model.panel.GaugePanel;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.graph.GraphPanel;
import com.redhat.developer.model.panel.heatmap.HeatMapPanel;
import com.redhat.developer.model.panel.PanelType;
import com.redhat.developer.model.panel.stat.SingleStatPanel;
import com.redhat.developer.model.panel.stat.StatPanel;
import com.redhat.developer.model.panel.table.TablePanel;

public class PanelFactory {

    public static GrafanaPanel CreatePanel(PanelType type, int id, String title, String expr){
        switch(type){
            case GRAPH:
                return createGraph(id, title, expr);
            case STAT:
                return createStat(id, title, expr);
            case HEATMAP:
                return createHeartMap(id, title, expr);
            case SINGLESTAT:
                return createSingleStat(id, title, expr);
            case TABLE:
                return createTable(id, title, expr);
            case GAUGE:
                return createGauge(id, title, expr);
            default:
                throw new UnsupportedOperationException("The panel " + type.toString() + " is not supported.");
        }
    }

    static GrafanaPanel createGraph(int id, String title, String expr){
        return new GraphPanel(id, title,
                              GridPosFactory.calculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel createStat(int id, String title, String expr){
        return new StatPanel(id, title,
                             GridPosFactory.calculateGridPosById(id),
                             TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel createHeartMap(int id, String title, String expr) {
        return new HeatMapPanel(id, title,
                                GridPosFactory.calculateGridPosById(id),
                                TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel createSingleStat(int id, String title, String expr){
        return new SingleStatPanel(id, title,
                                   GridPosFactory.calculateGridPosById(id),
                                   TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel createGauge(int id, String title, String expr){
        return new GaugePanel(id, title,
                              GridPosFactory.calculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel createTable(int id, String title, String expr){
        return new TablePanel(id, title,
                              GridPosFactory.calculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

}
