package com.funtik.aprocsination.parser.fpu;

import java.io.File;

/**
 *
 * @author funtik
 */
public class FPU {
    private static final Stack ST = new Stack(512);
    
    public static void abs(){ ST.top(Math.abs(ST.top())); }
    public static void add(){ ST.top(ST.pop()+ST.top()); }
    public static void sub(){ double d = ST.pop(); ST.top(ST.top()-d); }
    public static void mul(){ ST.top(ST.pop()*ST.top()); }
    public static void div(){ double d = ST.pop(); ST.top(ST.top()/d); }
    public static void divInt(){ double d = ST.pop(); ST.top((int)(ST.top()/d)); }
    public static void mod(){ double d = ST.pop(); ST.top(ST.top()%d); }
    public static void pow(){ double d = ST.pop(); ST.top(Math.pow(ST.top(), d)); }
    public static void cos(){ ST.top(Math.cos(ST.top())); }
    public static void sin(){ ST.top(Math.sin(ST.top())); }
    public static void tan(){ ST.top(Math.tan(ST.top())); }
    public static void ctg(){ ST.top(1/Math.tan(ST.top())); }
    
    public static void abs(Number n){ ST.push(Math.abs(n.doubleValue())); }
    public static void add(Number n){ ST.top(ST.top()+n.doubleValue()); }
    public static void sub(Number n){ ST.top(ST.top()-n.doubleValue()); }
    public static void mul(Number n){ ST.top(ST.top()*n.doubleValue()); }
    public static void div(Number n){ ST.top(ST.top()/n.doubleValue()); }
    public static void divInt(Number n){ ST.top((int)(ST.top()/n.doubleValue())); }
    public static void mod(Number n){ ST.top(ST.top()%n.doubleValue()); }
    public static void pow(Number n){ ST.top(Math.pow(ST.top(), n.doubleValue()));}
    public static void cos(Number n){ ST.push(Math.cos(n.doubleValue())); }
    public static void sin(Number n){ ST.push(Math.sin(n.doubleValue())); }
    public static void tan(Number n){ ST.push(Math.tan(n.doubleValue())); }
    public static void ctg(Number n){ ST.push(1/Math.tan(n.doubleValue())); }

    public static void add(Number l, Number r){ ST.push(l.doubleValue()+r.doubleValue()); }
    public static void sub(Number l, Number r){ ST.push(l.doubleValue()-r.doubleValue()); }
    public static void mul(Number l, Number r){ ST.push(l.doubleValue()*r.doubleValue()); }
    public static void div(Number l, Number r){ ST.push(l.doubleValue()/r.doubleValue()); }
    public static void divInt(Number l, Number r){ ST.push((int)(l.doubleValue()/r.doubleValue())); }
    public static void mod(Number l, Number r){ ST.push(l.doubleValue()%r.doubleValue()); }
    public static void pow(Number l, Number r){ ST.push(Math.pow(l.doubleValue(), r.doubleValue())); }
    
    
    public static double run(File f){
        return 0;
    }
    public static double run(String s){
        return 0;
    }
    public static double run(StringBuilder sb){
        return 0;
    }
}
