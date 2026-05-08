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

        try{
            if (user.isEmpty()||password.isEmpty()){
               throw new InvalidCredentialsException("Fields can't be empty !");

            }
            else if (!Validator.IsOnlyLetters(user)){
                throw new InvalidStringException("user field should be letters only");

            }
            else if(user.equals("admin")&&password.equals("123")){
                openDashboard(ev,"admin.fxml");
            }
            else if(user.equals("user")&&password.equals("123")){
                  openDashboard(ev,"customer.fxml");
            }
            else {
                throw new InvalidCredentialsException("Wrong username or password!");
            }


        }
        catch (IOException e){
            UI.showAlert("not found page",e.getMessage());
        }
        catch (InvalidCredentialsException e){
            UI.showAlert("login Error !",e.getMessage());
            UI.clearFields(textField, passwordField);
        }
        catch (InvalidStringException e){
            UI.showAlert("user Error !",e.getMessage());

        }
    }




    private void openDashboard(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        stage.setTitle("Supermarket Management System");

        try {
            javafx.scene.image.Image icon = new javafx.scene.image.Image(getClass().getResourceAsStream("icon.png"));
            stage.getIcons().add(icon);
        } catch (Exception e) {
            System.out.println("Logo image not found, proceeding without it.");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}