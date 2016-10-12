package com.funtik.aprocsination;

import javafx.application.Application;
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
        Pane root = Func.loadPane("Window");
        
        Scene scene = new Scene(root);
        
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
