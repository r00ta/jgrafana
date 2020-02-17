package com.redhat.developer;

import java.io.File;

import com.redhat.developer.model.GrafanaDashboard;

public interface IJGrafana {

    GrafanaDashboard parse(String dashboard);

    GrafanaDashboard parse(File dashboardPath);

}
