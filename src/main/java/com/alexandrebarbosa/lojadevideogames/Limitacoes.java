package com.alexandrebarbosa.lojadevideogames;

import javafx.scene.control.TextField;

public class Limitacoes {

    public static void setTextFieldInteger(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*")) {
                txt.setText(oldValue);
            }
        });
    }

    public static void setTextFieldDouble(TextField txt) {
        txt.textProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue != null && !newValue.matches("\\d*([.]\\d*)?")) {
                txt.setText(oldValue);
            }
        });
    }


}
