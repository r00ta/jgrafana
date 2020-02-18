package com.redhat.developer.factories;

import com.redhat.developer.model.panel.GrafanaGridPos;

class GridPosFactory {
    static GrafanaGridPos CalculateGridPosById(int id){
        return new GrafanaGridPos(12 * ( (id - 1) % 2), 8 * ((id - 1) / 2), 12, 8);
    }
}
