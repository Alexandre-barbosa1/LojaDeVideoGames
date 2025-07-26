package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Bem-vindo à Loja de Videogames!");
    }


    @FXML
    protected void onActionGamesButtonClick() {
        welcomeText.setText("Você clicou em Jogos de Ação!");

    }


    @FXML
    protected void onStrategyGamesButtonClick() {
        welcomeText.setText("Você clicou em Jogos de Estratégia!");

    }
    @FXML
    protected void onOpenSecondWindowButtonClick(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondView.fxml"));
        Scene secondScene = new Scene(fxmlLoader.load());
        Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        currentStage.setScene(secondScene);
        currentStage.setTitle("Minha Segunda Janela");
        currentStage.show();
    }

}