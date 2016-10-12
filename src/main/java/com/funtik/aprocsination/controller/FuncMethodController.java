package com.funtik.aprocsination.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class FuncMethodController implements Initializable {

    
    @FXML
    private VBox vbProperti;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void calc(){}
    public void test(){
        vbProperti.getChildren().add(new Label("wadaw"));
    }
}
