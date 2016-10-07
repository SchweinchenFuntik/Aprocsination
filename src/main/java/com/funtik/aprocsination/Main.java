package com.funtik.aprocsination;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author funtik
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Pane root = null;
        try{
            root = FXMLLoader.load(Main.class.getResource("/fxml/Window.fxml"));
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Построения графиков");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
