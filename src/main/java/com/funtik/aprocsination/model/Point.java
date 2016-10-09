package com.funtik.aprocsination.model;

import javafx.beans.property.*;
/**
 *
 * @author funtik
 */
public class Point {
    private final DoubleProperty t;
    private final DoubleProperty x;
    private final DoubleProperty y;
    
    public Point(){
        this.t = new SimpleDoubleProperty(0);
        this.x = new SimpleDoubleProperty(0);
        this.y = new SimpleDoubleProperty(0);
    }
    public Point(double t, double x, double y){
        this.t = new SimpleDoubleProperty(t);
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
    }

    /**
     * @return the t
     */
    public double getT() {
        return t.doubleValue();
    }

    /**
     * @param t the t to set
     */
    public void setT(double t) {
        this.t.set(t);
    }

    /**
     * @return the x
     */
    public double getX() {
        return x.doubleValue();
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x.set(x);
    }

    /**
     * @return the y
     */
    public double getY() {
        return y.doubleValue();
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y.set(y);
    }
}
