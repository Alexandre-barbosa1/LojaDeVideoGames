package com.alexandrebarbosa.lojadevideogames;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Navegacao {
    public static class Bloco {
        public String fxml;
        public Bloco ant;

        public Bloco(String fxml) {
            this.fxml = fxml;
            this.ant = null;
        }
    }

    public static Bloco topo = new Bloco("Janela-1.fxml");

    public static void add(String caminho) {
        Bloco novo = new Bloco(caminho);
        novo.ant = topo;
        topo = novo;
    }

    public static void remover() {
        if (topo == null) {
            return;
        } else {
            topo = topo.ant;
        }
    }
    public static void caminho(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Navegacao.class.getResource(Navegacao.topo.fxml));
        Scene cenaAnterior = new Scene(fxmlLoader.load());
        Stage stageAtual = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stageAtual.setScene(cenaAnterior);
        stageAtual.show();
    }
}