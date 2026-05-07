package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddProductController {

    @FXML private TextField idField;
    @FXML private TextField nameField;
    @FXML private TextField categoryField;
    @FXML private TextField priceField;
    @FXML private TextField quantityField;

    private AdminController adminController;

    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    private void handleSave(ActionEvent event) throws InvalidProductException {
        try{
        String id =idField.getText();
        String name=nameField.getText();
        String category=categoryField.getText();
        if (id.isEmpty()||name.isEmpty()||category.isEmpty()){
            throw new InvalidProductException("you must fill all fields !");
        }
        double price=Double.parseDouble(priceField.getText());
        int quantity= Integer.parseInt(quantityField.getText());


        }catch (InvalidProductException e){

        }


    }

}