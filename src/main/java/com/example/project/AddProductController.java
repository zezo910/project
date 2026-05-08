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
    private boolean isEditMode = false;
    private Item currentItem;

    private AdminController adminController;


    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    @FXML
    private void handleSave(ActionEvent event) throws InvalidProductException {

        try {


            if(isEditMode){
                String name = nameField.getText();
                String category = categoryField.getText();
                if ( nameField.getText().isEmpty() || categoryField.getText().isEmpty() ||
                        priceField.getText().isEmpty() || quantityField.getText().isEmpty()) {
                    throw new InvalidCredentialsException("Fields can't be empty !");

                }

                if ((!Validator.IsOnlyLetters(name))
                        || (!Validator.IsOnlyLetters(category))) {
                    throw new InvalidStringException("name and category must be letters and id digits only!");

                } double price;
                int quantity;
                try {
                    price = Double.parseDouble(priceField.getText());
                    quantity = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException e) {
                    throw new InvalidNumberException("Price and quantity must be valid numbers!");
                }
                if (((!Validator.IsNotZero(price)) || (!Validator.IsPositive(price))) ||
                        ((!Validator.IsNotZero(quantity)) || (!Validator.IsPositive(quantity)))) {
                    throw new InvalidNumberException("price and quantity must be greater than zero !");
                }

                currentItem.setName(name);
                currentItem.setCategory(category);
                currentItem.setPrice(price);
                currentItem.setQuantity(quantity);

                if (adminController!=null){
                    adminController.refreshTable();
                }
                UI.showSuccess("Updated Successfully", "The product '" + name + "' has been updated.", "success.png", "icon.png");

            }else {
                String id1 = idField.getText();
                String name1 = nameField.getText();
                String category1 = categoryField.getText();

                if (idField.getText().isEmpty() || nameField.getText().isEmpty() || categoryField.getText().isEmpty() ||
                        priceField.getText().isEmpty() || quantityField.getText().isEmpty()) {
                    throw new InvalidCredentialsException("Fields can't be empty !");

                }
                double price1;
                int quantity1;
                try {
                    price1 = Double.parseDouble(priceField.getText());
                    quantity1 = Integer.parseInt(quantityField.getText());
                } catch (NumberFormatException e) {
                    throw new InvalidNumberException("Price and quantity must be valid numbers!");
                }
                if ((!Validator.isOnlyDigits(priceField.getText()))||(!Validator.isOnlyDigits(quantityField.getText()))){
                    throw new InvalidNumberException("price and quantity must be numbers only !");
                }
                else if (((!Validator.IsNotZero(price1)) || (!Validator.IsPositive(price1))) ||
                        ((!Validator.IsNotZero(quantity1)) || (!Validator.IsPositive(quantity1)))) {
                    throw new InvalidNumberException("price and quantity must be greater than zero !");
                }

                Item item = new Item(id1, name1, category1, price1, quantity1);
                if (adminController != null) {
                    adminController.addProductToTable(item);
                }
                UI.showSuccess("Added Successfully", "The product '" + name1 + "' has been inserted to the inventory.", "success.png", "icon.png");
            }


            handleCancel(event);


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
    public void SetItemEdit(Item item){
        this.isEditMode = true;
        this.currentItem = item;
        idField.setText(item.getId());
        idField.setDisable(true);
        nameField.setText(item.getName());
        categoryField.setText(item.getCategory());
        priceField.setText(String.valueOf(item.getPrice()));
        quantityField.setText(String.valueOf(item.getQuantity()));

    }
}