package com.funtik.aprocsination.controller;

import com.funtik.aprocsination.Excel;
import com.funtik.aprocsination.Func;
import com.funtik.aprocsination.Main;
import com.funtik.aprocsination.model.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * FXML Controller class
 *
 * @author funtik
 */
public class WindowController extends Controller implements Initializable {
    
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
        Pane p = Func.loadPane("Apro");
       // sel = rmiFunc;
        //hash.put("Func", p);
        //hash.put("Point", Func.loadPane("Point"));
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
    
    public void excelImport(){
        FileChooser f = new FileChooser();
        f.setTitle("Импорт");
        FileChooser.ExtensionFilter filterXLSX = new FileChooser.ExtensionFilter("MS Excel 2007 (*.xlsx)", "*.xlsx");
        FileChooser.ExtensionFilter filterXLS = new FileChooser.ExtensionFilter("MS Excel 2003 (*.xls)", "*.xls");
        f.getExtensionFilters().addAll(filterXLS, filterXLSX);
        File file = f.showOpenDialog(Main.stage);
        Excel.importFile(file);
    }
    
    public void excelExport(){
        FileChooser f = new FileChooser();
        f.setTitle("Експорт");
        FileChooser.ExtensionFilter filterXLSX = new FileChooser.ExtensionFilter("MS Excel 2007 (*.xlsx)", "*.xlsx");
        FileChooser.ExtensionFilter filterXLS = new FileChooser.ExtensionFilter("MS Excel 2003 (*.xls)", "*.xls");
        f.getExtensionFilters().addAll(filterXLS, filterXLSX);
        File file = f.showSaveDialog(Main.stage);
        
        if(!file.exists()){
            if(filterXLSX.equals(f.getSelectedExtensionFilter())) file = new File(file.getPath()+".xlsx");
            else file = new File(file.getPath()+".xls");
        }
        Excel.exportFile(file);
    }
    
    
}
