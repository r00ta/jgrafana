package com.redhat.developer.factories;

import java.util.HashMap;

import com.redhat.developer.model.panel.GaugePanel;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.GraphPanel;
import com.redhat.developer.model.panel.HeatMapPanel;
import com.redhat.developer.model.panel.PanelType;
import com.redhat.developer.model.panel.SingleStatPanel;
import com.redhat.developer.model.panel.StatPanel;
import com.redhat.developer.model.panel.TablePanel;

public class PanelFactory {

    public static GrafanaPanel CreatePanel(PanelType type, int id, String title, String expr){
        switch(type){
            case GRAPH:
                return CreateGraph(id, title, expr);
            case STAT:
                return CreateStat(id, title, expr);
            case HEATMAP:
                return CreateHeartMap(id, title, expr);
            case SINGLESTAT:
                return CreateSingleStat(id, title, expr);
            case TABLE:
                return CreateTable(id, title, expr);
            case GAUGE:
                return CreateGauge(id, title, expr);
            default:
                throw new UnsupportedOperationException("The panel " + type.toString() + " is not supported.");
        }
    }

    static GrafanaPanel CreateGraph(int id, String title, String expr){
        return new GraphPanel(id, title,
                              GridPosFactory.CalculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel CreateStat(int id, String title, String expr){
        return new StatPanel(id, title,
                             GridPosFactory.CalculateGridPosById(id),
                             TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel CreateHeartMap(int id, String title, String expr) {
        return new HeatMapPanel(id, title,
                                GridPosFactory.CalculateGridPosById(id),
                                TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel CreateSingleStat(int id, String title, String expr){
        return new SingleStatPanel(id, title,
                                   GridPosFactory.CalculateGridPosById(id),
                                   TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel CreateGauge(int id, String title, String expr){
        return new GaugePanel(id, title,
                              GridPosFactory.CalculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

    static GrafanaPanel CreateTable(int id, String title, String expr){
        return new TablePanel(id, title,
                              GridPosFactory.CalculateGridPosById(id),
                              TargetFactory.CreateTargets(expr));
    }

}
