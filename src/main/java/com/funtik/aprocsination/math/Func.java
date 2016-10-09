package com.funtik.aprocsination.math;

import java.io.IOException;
import java.util.function.UnaryOperator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;

/**
 *
 * @author funtik
 */
public class Func {
    public static final UnaryOperator<TextFormatter.Change> FILTER_DOUBLE = (t) -> {
        String s = t.getControlNewText();
        if(s.equals("") || Func.isDouble(s)) return t;
        return null;
    };
    public static final UnaryOperator<TextFormatter.Change> FILTER_INT = (t) -> {
        String s = t.getControlNewText();
        if(s.equals("") || Func.isInteger(s)) return t;
        return null;
    };
    
    public static boolean isDouble(String s){
        boolean b = false;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c=='.' && !b) b = true; 
            else if(!(c>='0' && c<='9') || (b && c=='.')) return false;
        }
        return true;
    }
    public static boolean isInteger(String s){
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!(c>='0' && c<='9')) return false;
        }
        return true;
    }
    public static Pane loadPane(String name){
        Pane pane = null;
        try{
            pane = FXMLLoader.load(Func.class.getResource("/fxml/"+name+".fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Func.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pane;
    }
}
