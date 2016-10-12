package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.Func;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class WindowController implements Initializable {
    
    private final ObservableMap<String, Node> hash = FXCollections.observableHashMap();
    
    @FXML
    private VBox pane;
    @FXML
    private RadioMenuItem rmiFunc;
    @FXML
    private RadioMenuItem rmiPoint;

    private RadioMenuItem sel;
            
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane p = Func.loadPane("Func");
        sel = rmiFunc;
        hash.put("Func", p);
        hash.put("Point", Func.loadPane("Point"));
        pane.getChildren().add(p);
    }    
    public void actionMiPoint(){
        if(sel==rmiPoint) return;
        sel = rmiPoint;
        hash.put("Func", pane.getChildren().get(1));
        selectPane("Point");
    }
    public void actionMiFunc(){
        if(sel==rmiFunc) return;
        sel = rmiFunc;
        hash.put("Point", pane.getChildren().get(1));
        selectPane("Func");
    }
    
    private void selectPane(String key){ 
        Node n = hash.get(key);
        if(n==null) n = Func.loadPane(key);
        pane.getChildren().remove(1);
        pane.getChildren().add(n);
    }
}
