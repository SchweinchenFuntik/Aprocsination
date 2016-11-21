package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.model.Point;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class AproController extends Controller implements Initializable {
    
    @FXML
    private BorderPane pane;
    
    @FXML
    private ChoiceBox cbMethod;
    @FXML 
    private TableView<Point> table;
    @FXML
    private TableColumn<Point, Double> columnX;
    private TableColumn<Point, Double> columnY;
    
    private final ObservableList<Point> dataTable = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //columnX.setCellValueFactory(new PropertyValueFactory<Point, Double>("x"));
        //columnY.setCellValueFactory(new PropertyValueFactory<Point, Double>("y"));
        
        //dataTable.addAll(new Point(0, 0));
       // dataTable.addAll(new Point(23, 0));
       // dataTable.addAll(new Point(0, 1320));
       // dataTable.addAll(new Point(1230, 031));
    }    
    
}
