package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Janela_1_Controller {

    @FXML
    protected void onOpenSecondWindowButtonClick(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Janela-2.fxml"));
        Scene secondScene = new Scene(fxmlLoader.load());
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(secondScene);
        currentStage.setTitle("Minha Segunda Janela");
        currentStage.show();
    }

}