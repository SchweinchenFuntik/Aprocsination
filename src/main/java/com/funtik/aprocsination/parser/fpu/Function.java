package com.funtik.aprocsination.parser.fpu;

/**
 *
 * @author funtik
 */
public class Function {
    private String load;
    private String name;
    private String func;
    private String path;
    private int param;
    
    public Function(String name, String func){
        this.name = name; this.func = func; this.param = 0;
    }
    public Function(String name, String func, int param){
        this.name = name; this.func = func; this.param = param;
    }
    public Function(String name, String load, String path){
        this.name = name; this.load = load; this.path = path;
    }
    public Function(String name, String load, String path, String func, int param){
        this.name = name; this.load = load; this.func = func; this.param = param;
    }
    
    public void setName(String name){ this.name = name; }
    public void setLoad(String load){ this.load = load; }
    public void setFunc(String func){ this.func = func; }
    
    private static String load(Function f){
        
        return null;
    }

    @Override
    public String toString() {
        return (func==null) ? load(this):func;
    }
}
