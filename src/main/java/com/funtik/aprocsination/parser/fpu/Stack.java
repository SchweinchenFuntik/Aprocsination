package com.funtik.aprocsination.parser.fpu;

/**
 *
 * @author funtik
 */
public class Stack{
    private double [] st;
    private int sz;
    
    public Stack(){ st = new double[256]; }
    public Stack(int sz){ st = new double[sz]; }
    
    public void push(double v){ st[sz++] = v; }
    public double pop(){ return st[sz--]; }
    public double top(){ return st[sz]; }
    public void top(Number n){ st[sz] = n.doubleValue(); }  
}
