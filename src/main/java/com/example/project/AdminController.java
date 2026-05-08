package com.example.project;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class AdminController {

    @FXML private TableView<Item> inventoryTable;
    @FXML private TableColumn<Item, String> idCol;
    @FXML private TableColumn<Item, String> nameCol;
    @FXML private TableColumn<Item, String> categoryCol;
    @FXML private TableColumn<Item, Double> priceCol;
    @FXML private TableColumn<Item, Integer> quantityCol;
    @FXML private TextField searchField;

    @FXML
    public void initialize() {

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));


        inventoryTable.getItems().add(new Item("101", "Milk", "Dairy", 25.0, 50));
        inventoryTable.getItems().add(new Item("102", "Bread", "Bakery", 10.0, 30));
    }


    @FXML
    private void handleAddItem() {
        try {
            javafx.fxml.FXMLLoader loader = new javafx.fxml.FXMLLoader(getClass().getResource("add_product.fxml"));
            javafx.scene.Parent root = loader.load();

            AddProductController addController = loader.getController();
            addController.setAdminController(this);

            javafx.stage.Stage stage = new javafx.stage.Stage();
            stage.setTitle("Add New Product");
            stage.setScene(new javafx.scene.Scene(root));

            stage.initModality(javafx.stage.Modality.APPLICATION_MODAL);
            stage.show();

        } catch (IOException e) {
            System.out.println("Error loading Add Product screen: " + e.getMessage());
        }
    }
    @FXML
    public void addProductToTable(Item item) {
        inventoryTable.getItems().add(item);
    }
}