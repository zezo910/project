package com.example.project;

public class UI {
    public static void clearFields(javafx.scene.control.TextField... fields) {
        for (javafx.scene.control.TextField field : fields) {
            field.clear();
        }
    }
    public static void showAlert(String title, String message) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    public static boolean showConfirmation(String title, String message,String pathLogo) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        try {

                if (pathLogo != null && !pathLogo.isEmpty()) {
                    javafx.stage.Stage stage = (javafx.stage.Stage) alert.getDialogPane().getScene().getWindow();
                    javafx.scene.image.Image windowLogo = new javafx.scene.image.Image(UI.class.getResourceAsStream(pathLogo)); // غيرنا الاسم لـ windowLogo
                    stage.getIcons().add(windowLogo);
                }


        }catch(Exception e) {
            System.out.println("Image not found, proceeding without it: " + e.getMessage());
        }

        java.util.Optional<javafx.scene.control.ButtonType> result = alert.showAndWait();

        return result.isPresent() && result.get() == javafx.scene.control.ButtonType.OK;
    }
    public static void showSuccess(String title, String message, String pathIcon, String pathLogo) {
        javafx.scene.control.Alert alert = new javafx.scene.control.Alert(javafx.scene.control.Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        try {
            if (pathIcon != null && !pathIcon.isEmpty()) {
                javafx.scene.image.ImageView alertIcon = new javafx.scene.image.ImageView(
                        new javafx.scene.image.Image(UI.class.getResourceAsStream(pathIcon))
                );
                alertIcon.setFitHeight(48);
                alertIcon.setFitWidth(48);
                alert.setGraphic(alertIcon);

                if (pathLogo != null && !pathLogo.isEmpty()) {
                    javafx.stage.Stage stage = (javafx.stage.Stage) alert.getDialogPane().getScene().getWindow();
                    javafx.scene.image.Image windowLogo = new javafx.scene.image.Image(UI.class.getResourceAsStream(pathLogo)); // غيرنا الاسم لـ windowLogo
                    stage.getIcons().add(windowLogo);
                }

            }
        }catch(Exception e) {
            System.out.println("Image not found, proceeding without it: " + e.getMessage());
        }

        alert.showAndWait();
    }
}
