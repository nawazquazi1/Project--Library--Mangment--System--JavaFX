package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LibraryAssistant extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("add_book.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(LibraryAssistant.class.getResource("add_book.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
