package com.funtik.aprocsination;

/**
 *
 * @author funtik
 */
public class ConverterStringDouble extends javafx.util.StringConverter<Double>{

    @Override
    public String toString(Double d){
        return (d!=null) ? String.valueOf(d.doubleValue()):"0.0";
    }

    @Override
    public Double fromString(String s){
        return (s==null || !Func.isDouble(s)) ? null:Double.parseDouble(s);
    }
    
}
