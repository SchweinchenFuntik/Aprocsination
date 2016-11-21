package com.funtik.aprocsination.math;

import java.math.BigDecimal;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 *
 * @author funtik
 */
public class Beze {
    public static double getBasik(int n, double t, int i){
        return (new BigDecimal(Math.pow(t, i)*Math.pow(1-t, n-i)))
                .multiply(M.factorialDecimal(n).divide(M.factorialDecimal(i)
                        .multiply(M.factorialDecimal(n-i))))
                .doubleValue();
    }
    
    public static void calcBeze(double dt, ObservableList<XYChart.Data> data, P [] p){
        int n = p.length;
        for(double t = 0; t<=1+dt; t+=dt){
            double x = 0, y = 0;
            for(int i=0; i<n; i++){
                double d = getBasik(n, t, i);
                P tmp_p = p[i]; 
                x += tmp_p.x*d;
                y += tmp_p.y*d;
            }
            // add result
        }
    }
    
    public static  class P{
        public double x, y;
    }        
}
