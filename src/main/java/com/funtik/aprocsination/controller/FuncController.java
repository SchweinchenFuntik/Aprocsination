package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.ConverterStringDouble;
import com.funtik.aprocsination.Func;
import com.funtik.aprocsination.model.Point;
import java.awt.BorderLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class FuncController extends Controller implements Initializable {
    
    private final ObservableMap<String, Node> hash = FXCollections.observableHashMap();
    private final ObservableMap<String, ObservableList<Point>> hashDataTable 
            = FXCollections.observableHashMap();
    private final ObservableMap<String, 
            ObservableList<XYChart.Series<Double, Double>>> hashDataGraph
            = FXCollections.observableHashMap();
    
    private ObservableList<XYChart.Series<Double, Double>> dataGraph 
            = FXCollections.observableArrayList();
    private final ObservableList<Point> dataTable = FXCollections.observableArrayList();
 
    @FXML
    private BorderPane pane;
    @FXML
    private LineChart<Double, Double> graph;
    @FXML
    private TableView<Point> table;
    @FXML
    private TableColumn<Point, Double> tcT;
    @FXML
    private TableColumn<Point, Double> tcX;
    @FXML
    private TableColumn<Point, Double> tcY;
    @FXML
    private ChoiceBox<String> cbMethod;
    
    private final ConverterStringDouble converterTableCell = new ConverterStringDouble();
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Pane p = Func.loadPane("FuncMethod");
        BorderPane.setAlignment(p, Pos.BOTTOM_LEFT);
        pane.setLeft(p);
        hash.put("FuncMethod", p);
        
        tcT.setCellValueFactory(new PropertyValueFactory<>("t"));
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        
        tcT.setCellFactory(TextFieldTableCell.<Point, Double>forTableColumn(converterTableCell));
        tcX.setCellFactory(TextFieldTableCell.<Point, Double>forTableColumn(converterTableCell));
        tcY.setCellFactory(TextFieldTableCell.<Point, Double>forTableColumn(converterTableCell));
        
        table.setItems(dataTable);
        
        graph.setData(dataGraph);
    }
    
    public void actionCbMethod(){}
    
    public void addDataGraph(ObservableList<XYChart.Data<Double, Double>> data){}
    public void setDataGraph(ObservableList<XYChart.Data<Double, Double>> data){}
    public void removeGraph(int n){}
    public void removeGraph(){}
}
