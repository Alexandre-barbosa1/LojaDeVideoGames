package com.alexandrebarbosa.lojadevideogames;

import javafx.scene.control.Alert;

public class Alertas {
    public static void showAlert(String title, String header, String content, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }

}
