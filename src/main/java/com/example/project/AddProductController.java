package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

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

        try {
            String id = idField.getText();
            String name = nameField.getText();
            String category = categoryField.getText();

            if (idField.getText().isEmpty() || nameField.getText().isEmpty() || categoryField.getText().isEmpty() ||
                    priceField.getText().isEmpty() || quantityField.getText().isEmpty()) {
                throw new InvalidCredentialsException("Fields can't be empty !");

            }
            double price= Double.parseDouble(priceField.getText());
            int quantity=Integer.parseInt(quantityField.getText());

            if ((!Validator.isOnlyDigits(id)) || (!Validator.IsOnlyLetters(name))
                    || (!Validator.IsOnlyLetters(category))) {
                throw new InvalidStringException("name and category must be letters and id digits only!");

            } else if (((!Validator.IsNotZero(price)) || (!Validator.IsPositive(price))) ||
                    ((!Validator.IsNotZero(quantity)) || (!Validator.IsPositive(quantity)))) {
                throw new InvalidNumberException("price and quantity must be greater than zero !");
            }
            Item item =new Item(id,name,category,price,quantity);
            adminController.addProductToTable(item);
            handleCancel(event);
            UI.showSuccess("added Successfully", "The product '" + name + "' has been inserted to the inventory.","success.png","add.png");


        } catch (InvalidCredentialsException e) {
            UI.showAlert("add product Error !", e.getMessage());
            UI.clearFields(idField, nameField, categoryField, priceField, quantityField);
        } catch (InvalidStringException e) {
            UI.showAlert(" letters and digits only", e.getMessage());
            UI.clearFields(idField, nameField, categoryField, priceField, quantityField);

        } catch (InvalidNumberException e) {

            UI.showAlert(" greater than zero ", e.getMessage());
            UI.clearFields(idField, nameField, categoryField, priceField, quantityField);

        }




    }
    public  void  handleCancel(ActionEvent event){
    Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.close();
    }

}