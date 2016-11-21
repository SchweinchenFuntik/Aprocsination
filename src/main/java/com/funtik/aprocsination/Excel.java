package com.funtik.aprocsination;

import com.funtik.aprocsination.controller.Controller;
import com.funtik.aprocsination.controller.PointController;
import com.funtik.aprocsination.controller.WindowController;
import com.funtik.aprocsination.model.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javax.activation.DataSource;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Chart;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.charts.AxisPosition;
import org.apache.poi.ss.usermodel.charts.ChartAxis;
import org.apache.poi.ss.usermodel.charts.ChartDataSource;
import org.apache.poi.ss.usermodel.charts.ChartLegend;
import org.apache.poi.ss.usermodel.charts.DataSources;
import org.apache.poi.ss.usermodel.charts.LegendPosition;
import org.apache.poi.ss.usermodel.charts.LineChartData;
import org.apache.poi.ss.usermodel.charts.ValueAxis;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author funtik
 */
public class Excel {
    public static void exportFile(File f){
        Workbook wb = new XSSFWorkbook();
        
        Sheet sheet = wb.createSheet("Graph");
        
        PointController con = (PointController) Controller.HASH.get("Point");
        ObservableList<Point> al = con.data;
        
        CellStyle style = wb.createCellStyle();
        style.setAlignment(HorizontalAlignment.CENTER);
        
        Row row = sheet.createRow(0);
        Cell cel = row.createCell(0);
        cel.setCellValue("X"); cel.setCellStyle(style);
        cel = row.createCell(1);
        cel.setCellValue("Y"); cel.setCellStyle(style);
        
        int i = 0;
        for(; i<al.size(); i++){
            Point p = al.get(i);
            row = sheet.createRow(i+1);
            cel = row.createCell(0); cel.setCellStyle(style);
            cel.setCellValue(p.getX());
            cel = row.createCell(1); cel.setCellStyle(style);
            cel.setCellValue(p.getY());
        }
        
        Drawing draw = sheet.createDrawingPatriarch();
        ClientAnchor anchor = draw.createAnchor(0, 0, 0, 0, 4, 0, 14, 10);
        Chart chart = draw.createChart(anchor);
        ChartLegend legend = chart.getOrCreateLegend();
        legend.setPosition(LegendPosition.BOTTOM);
        
        LineChartData data = chart.getChartDataFactory().createLineChartData();
        ChartAxis bottomAxis = chart.getChartAxisFactory().createCategoryAxis(AxisPosition.BOTTOM);
        ValueAxis leftAxis = chart.getChartAxisFactory().createValueAxis(AxisPosition.LEFT);
        
        ChartDataSource<Number> x = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, i, 0, 0));
        ChartDataSource<Number> y = DataSources.fromNumericCellRange(sheet, new CellRangeAddress(1, i, 1, 1));
        
        data.addSeries(x, y);
        
        chart.plot(data, bottomAxis, leftAxis);
        
        FileOutputStream out;
        try {
            out = new FileOutputStream(f);
            wb.write(out);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void importFile(File f){}
    
    private void scatterChart(Sheet sheet){}
    private void lineChart(Sheet sheet){}
    
}
