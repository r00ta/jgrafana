package com.redhat.developer.model.functions;

public class SumFunction implements GrafanaFunction{

    private final static String function = "sum";

    public SumFunction(){}

    @Override
    public String getFunction() {
        return function;
    }

    @Override
    public boolean hasTimeParameter() {
        return false;
    }

    @Override
    public String getTimeParameter() {
        return null;
    }

}
