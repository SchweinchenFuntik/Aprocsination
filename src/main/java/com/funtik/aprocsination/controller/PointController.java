package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.ConverterStringDouble;
import com.funtik.aprocsination.model.Point;
import com.funtik.aprocsination.Func;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class PointController extends Controller implements Initializable {
    
    public  ObservableList<Point> data = FXCollections.observableArrayList();
    
    @FXML
    private LineChart<Double, Double> graph;
    @FXML
    private TableView<Point> table;
    @FXML
    private TableColumn<Point, Double> tcX;
    @FXML
    private TableColumn<Point, Double> tcY;
    @FXML
    private TextField tfX;        
    @FXML
    private TextField tfY;
    
    private final ConverterStringDouble converterTableCell = new ConverterStringDouble();
    private final ObservableList<XYChart.Data<Double, Double>> dataGraph 
            = FXCollections.observableArrayList();        
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {  
        graph.setAxisSortingPolicy(LineChart.SortingPolicy.NONE);
        
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcX.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcX.setOnEditCommit((TableColumn.CellEditEvent<Point, Double> e) -> {
            Double d = e.getNewValue(); Double dd = e.getOldValue();
            if(d!=null){
                System.out.println(e.getNewValue());
                int row = e.getTablePosition().getRow();
                e.getTableView().getItems().get(row).setX(d);
                dataGraph.get(row).setXValue(d);
            }
        });
        
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        tcY.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcY.setOnEditCommit((TableColumn.CellEditEvent<Point, Double> e) -> {
            Double d = e.getNewValue(); Double dd = e.getOldValue();
            if(d!=null){
                System.out.println(e.getNewValue());
                int row = e.getTablePosition().getRow();
                e.getTableView().getItems().get(row).setY(d);
                dataGraph.get(row).setYValue(d);
            }
            
        });
        
        /*
        data.addListener((ListChangeListener.Change<? extends Point> c) -> {
            if(c.wasAdded()){
            } else if(c.wasReplaced()){
            } else if(c.wasRemoved()){
            }
        });*/
        
        //tcT.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        //tcX.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        //tcY.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        
        data.addListener((ListChangeListener.Change<? extends Point> c) -> {
            while(c.next()){
                if(c.wasAdded())
                    c.getAddedSubList().forEach(t -> {
                       dataGraph.add(c.getFrom(), new Data<>(t.getX(), t.getY()));
                    });
                else if(c.wasRemoved())  dataGraph.remove(c.getFrom());
            }
        });
        
        table.setItems(data);
       
        tfX.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
        tfY.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));

        graph.getData().add(new Series<>("Lines", dataGraph));
    }    
    
    public void add(){
        String sX = tfX.getText(), sY = tfY.getText();
        double t = 0, x = 0 ,y = 0;
        if(!sX.equals("")) x = Double.parseDouble(sX);
        if(!sY.equals("")) y = Double.parseDouble(sY);
        Point p = new Point(x, y);
        data.add(p); 
    }
    public void del(){
        data.remove(0);
    }
}
