package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {


    @FXML
    private TextField textField;
    @FXML
    private Label label;
    @FXML
    private PasswordField passwordField;
    public void login(ActionEvent ev){
        String user= textField.getText();
        String password= passwordField.getText();
        if (user.isEmpty()||password.isEmpty()){
            label.setText("you should input in fields !");
            label.setVisible(true);
            return;
        }
        try{
        if (user.equals("admin")&&password.equals("123")){
            openDashboard(ev,"admin.fxml");
        } else if (user.equals("user")&&password.equals("123")) {
            openDashboard(ev,"customer.fxml");

        }
        else {
            label.setText("invalid inputs !");
            label.setVisible(true);
        }
        }catch(IOException e){
        System.out.println("Error !"+e.getMessage());
        }
    }




    private void openDashboard(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}