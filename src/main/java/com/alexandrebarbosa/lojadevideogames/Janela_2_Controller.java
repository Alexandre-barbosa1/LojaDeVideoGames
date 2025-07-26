package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Janela_2_Controller {
    @FXML
    protected void onOpenBackWindowButtonClick(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Janela-1.fxml"));
        Scene firstScene = new Scene(fxmlLoader.load());
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(firstScene);
        currentStage.setTitle("Minha Primeira Janela");
        currentStage.show();
    }

}