package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import com.alexandrebarbosa.lojadevideogames.Navegacao;


import java.io.IOException;

public class Janela_1_Controller {
    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
            Navegacao.add("Janela-2.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Navegacao.topo.fxml));
            Scene cenaAnterior = new Scene(fxmlLoader.load());
            Stage stageAtual = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stageAtual.setScene(cenaAnterior);
            stageAtual.show();
    }
}