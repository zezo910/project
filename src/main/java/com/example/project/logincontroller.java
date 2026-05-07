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

public class logincontroller {

    // ربطنا العناصر اللي في التصميم بالكود
    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    // الفانكشن دي هتشتغل لما ندوس على زرار Login
    @FXML
    public void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // 1. Error Checking: التأكد إن الحقول مش فاضية
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please fill in all fields!");
            errorLabel.setVisible(true); // نظهر رسالة الغلط
            return; // نوقف الكود هنا وميكملش
        }

        try {
            // 2. التحقق من البيانات (مؤقتاً لحد ما يتم ربط الفايلات)
            if (username.equals("admin") && password.equals("123")) {
                // دخول المدير
                openDashboard(event, "admin.fxml");

            } else if (username.equals("user") && password.equals("123")) {
                // دخول العميل
                openDashboard(event, "customer.fxml");

            } else {
                // لو البيانات غلط
                errorLabel.setText("Invalid credentials, please try again.");
                errorLabel.setVisible(true);
            }
        } catch (IOException e) {
            // Exception Handling المطلوب في التقييم
            System.out.println("Error loading screen: " + e.getMessage());
        }
    }

    // دالة مساعدة (Helper Method) عشان منكررش كود فتح الشاشات مرتين
    private void openDashboard(ActionEvent event, String fxmlFile) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}