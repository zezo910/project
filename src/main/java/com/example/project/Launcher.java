package com.example.project;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) {
        Application.launch(shop.class, args);
    }

    public static class first_test {
        private Scene scene;
        private Parent root;
        private Stage stage;
        public void swich1(ActionEvent e) throws IOException {
            root = FXMLLoader.load(getClass().getResource("first_test.fxml"));
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
             scene = new Scene(root);
             stage.setScene(scene);
             stage.show();
        }
        public void swich2(ActionEvent e) throws IOException {
            root = FXMLLoader.load(getClass().getResource("second_test.fxml"));
            stage = (Stage)((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
}
