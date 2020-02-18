package com.redhat.developer.factories;

import java.util.ArrayList;
import java.util.List;

import com.redhat.developer.model.panel.GrafanaTarget;

public class TargetFactory {
    static List<GrafanaTarget> CreateTargets(String expr){
        List<GrafanaTarget> targets = new ArrayList<>();
        targets.add(new GrafanaTarget(expr, "time_series"));
        return targets;
    }
}
