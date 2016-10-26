package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.ConverterStringDouble;
import com.funtik.aprocsination.model.Point;
import com.funtik.aprocsination.Func;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.WeakEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;

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
    private TableColumn<Point, Double> tcT;
    @FXML
    private TableColumn<Point, Double> tcX;
    @FXML
    private TableColumn<Point, Double> tcY;
    
    @FXML
    private TextField tfT;
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
        tcT.setCellValueFactory(new PropertyValueFactory<>("t"));
        tcT.setCellFactory((list -> new MyCellEdit(converterTableCell)));
        tcT.setOnEditCommit((TableColumn.CellEditEvent<Point, Double> e) -> {
            Double d = e.getNewValue(); Double dd = e.getOldValue();
            if(d!=null){
                System.out.println(e.getNewValue());
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setT(d);
            }
            
        });
        
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcX.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcX.setOnEditCommit((TableColumn.CellEditEvent<Point, Double> e) -> {
            Double d = e.getNewValue(); Double dd = e.getOldValue();
            if(d!=null){
                System.out.println(e.getNewValue());
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setT(d);
            }
            
        });
        
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        tcY.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcY.setOnEditCommit((TableColumn.CellEditEvent<Point, Double> e) -> {
            Double d = e.getNewValue(); Double dd = e.getOldValue();
            if(d!=null){
                System.out.println(e.getNewValue());
                e.getTableView().getItems().get(e.getTablePosition().getRow()).setT(d);
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
        
        table.setItems(data);
        
        tfT.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
        tfX.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
        tfY.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));

        graph.getData().add(new Series<>("Lines", dataGraph));
    }    
    
    public void add(){
        String sT = tfT.getText(), sX = tfX.getText(), sY = tfY.getText();
        double t = 0, x = 0 ,y = 0;
        if(!sT.equals("")) t = Double.parseDouble(sT);
        if(!sX.equals("")) x = Double.parseDouble(sX);
        if(!sY.equals("")) y = Double.parseDouble(sY);
        Point p = new Point(t, x, y);
        data.add(p); 
        dataGraph.add(new XYChart.Data<>(p.getX(), p.getY()));
    }
    
    public class MyCellEdit<S,T> extends TextFieldTableCell<S,T>{
        
        public MyCellEdit(StringConverter<T> converter){
            super(converter);
        }

        @Override
        public void commitEdit(T t) {
            if(t==null) return;
            super.commitEdit(t);
        }

        @Override
        public void updateItem(T item, boolean empty) {
            super.updateItem(item, empty); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
}
