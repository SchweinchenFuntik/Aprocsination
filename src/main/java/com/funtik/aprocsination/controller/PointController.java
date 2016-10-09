package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.ConverterStringDouble;
import com.funtik.aprocsination.model.Point;
import com.funtik.aprocsination.math.Func;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class PointController implements Initializable {
    
    public  ObservableList<Point> data = FXCollections.observableArrayList();
    
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
            
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {   
        tcT.setCellValueFactory(new PropertyValueFactory<>("t"));
        tcX.setCellValueFactory(new PropertyValueFactory<>("x"));
        tcY.setCellValueFactory(new PropertyValueFactory<>("y"));
        
        tcT.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcX.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        tcY.setCellFactory(TextFieldTableCell.<Point,Double>forTableColumn(converterTableCell));
        
        table.setItems(data);
        data.add(new Point(1, 2, 3));
        data.add(new Point(1, 2, 3));
        data.add(new Point(1, 2, 3));
        
        
        tfT.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
        tfX.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
        tfY.setTextFormatter(new TextFormatter<>(Func.FILTER_DOUBLE));
    }    
    
    public void add(){
        String sT = tfT.getText(), sX = tfX.getText(), sY = tfY.getText();
        double t = 0, x = 0 ,y = 0;
        if(!sT.equals("")) t = Double.parseDouble(sT);
        if(!sX.equals("")) x = Double.parseDouble(sX);
        if(!sY.equals("")) y = Double.parseDouble(sY);
        data.add(new Point(t, x, y));
    }
}
