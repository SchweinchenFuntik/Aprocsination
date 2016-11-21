package com.funtik.aprocsination.parser;

/**
 *
 * @author funtik
 */
public class DoubleValue implements Value{
    private double val;
    
    public DoubleValue(){}
    public DoubleValue(Number n){ val = n.doubleValue(); }
    
    public void set(Number n){ val = n.doubleValue(); }

    @Override
    public double get() {
        return val;
    }   
}
