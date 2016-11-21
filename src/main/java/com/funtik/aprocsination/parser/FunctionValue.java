package com.funtik.aprocsination.parser;

/**
 *
 * @author funtik
 */
public abstract class FunctionValue implements Function, Value{
    private double [] param;
    private int size_param = -1;
    
    public FunctionValue(){}
    public FunctionValue(Number... n){
        size_param = n.length;
        param = new double[n.length];
        for(int i=0; i<n.length; i++) param[i] = n[i].doubleValue();
    }
    public FunctionValue(int sz_param, Number... n){
        size_param = sz_param;
        if(n.length!=sz_param) return;
        param = new double[sz_param];
        for(int i=0; i<sz_param; i++) param[i] = n[i].doubleValue();
    }
    
    public void setSize(int sz){ size_param = sz; param = new double[sz]; }

    @Override
    public Function param(Number... n) {
        if(size_param>-1 && n.length!=size_param) return null;
        for(int i=0; i<size_param; i++) param[i] = n[i].doubleValue();
        return this;
    }   
}
