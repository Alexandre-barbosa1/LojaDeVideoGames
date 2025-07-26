package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Janela_2_Controller {

    @FXML
    protected void Voltar2(ActionEvent event) throws IOException {
            Navegacao.remover();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Navegacao.topo.fxml));
            Scene cenaAnterior = new Scene(fxmlLoader.load());
            Stage stageAtual = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageAtual.setScene(cenaAnterior);
            stageAtual.show();
    }
}