package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class shop extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root =  FXMLLoader.load(getClass().getResource("login.fxml"));


        Scene scene = new Scene(root);
        String css= this.getClass().getResource("/com/example/project/login.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init()  {
        System.out.print("ha3 3abet");
    }

    @Override
    public void stop() {


    }

    public static void main(String[] args){
        launch(args);
    }
}
