package com.redhat.developer.model.functions;

public interface GrafanaFunction {
    String getFunction();

    boolean hasTimeParameter();

    String getTimeParameter();
}
