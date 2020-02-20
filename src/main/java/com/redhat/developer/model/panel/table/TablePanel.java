package com.redhat.developer.model.panel.table;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.redhat.developer.model.panel.GrafanaGridPos;
import com.redhat.developer.model.panel.GrafanaPanel;
import com.redhat.developer.model.panel.GrafanaTarget;
import com.redhat.developer.model.panel.table.BaseStyle;
import com.redhat.developer.model.panel.table.DateStyle;
import com.redhat.developer.model.panel.table.NumberStyle;
import com.redhat.developer.model.panel.table.TableSort;

public class TablePanel extends GrafanaPanel {

    @JsonProperty("fontSize")
    public String fontSize = "100%";

    @JsonProperty("showHeader")
    public boolean showHeader = true;

    @JsonProperty("styles")
    public List<BaseStyle> styles = generateStyles();

    @JsonProperty("transform")
    public String transform = "timeseries_to_rows";

    @JsonProperty("sort")
    public TableSort sort = new TableSort();

    @JsonProperty("pageSize")
    public String pageSize;

    @JsonProperty("columns")
    public List<String> columns;


    public TablePanel(){
        super();
    }

    public TablePanel(int id, String title, GrafanaGridPos gridPos, List<GrafanaTarget> targets) {
        super(id, title, "table", gridPos, targets);
    }

    private List<BaseStyle> generateStyles(){
        List<BaseStyle> ll = new ArrayList<>();
        ll.add(new DateStyle());
        ll.add(new NumberStyle());
        return ll;
    }
}
