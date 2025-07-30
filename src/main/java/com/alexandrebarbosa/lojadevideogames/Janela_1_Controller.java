package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class Janela_1_Controller {
    @FXML
    protected void btAdicionarJogos(ActionEvent event) throws IOException {
        Navegacao.add("Janela-2.fxml");
        Navegacao.caminho(event);
    }

    @FXML
    protected void btListaDeJogos(ActionEvent event) throws IOException {
        Navegacao.add("Janela-3.fxml");
        Navegacao.caminho(event);
    }

    @FXML
    protected void btBuscarJogo(ActionEvent event) throws IOException {
        Navegacao.add("Janela-4.fxml");
        Navegacao.caminho(event);
    }


}