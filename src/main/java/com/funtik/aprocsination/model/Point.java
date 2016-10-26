package com.funtik.aprocsination.model;

import javafx.beans.property.*;
/**
 *
 * @author funtik
 */
public class Point {
    private final DoubleProperty x;
    private final DoubleProperty y;
    
    public Point(){
        this.x = new SimpleDoubleProperty(0);
        this.y = new SimpleDoubleProperty(0);
    }
    public Point(double x, double y){
        this.x = new SimpleDoubleProperty(x);
        this.y = new SimpleDoubleProperty(y);
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

    /**
     * @return the x
     */
    public DoubleProperty xProperty() {
        return x;
    }

    /**
     * @return the y
     */
    public DoubleProperty yProperty() {
        return y;
    }

}
