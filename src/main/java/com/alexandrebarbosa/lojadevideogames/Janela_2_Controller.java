package com.alexandrebarbosa.lojadevideogames;

import entidades.FilaJogo;
import entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Janela_2_Controller {
    public List<Jogo> jogos = new ArrayList<>();
    @FXML
    private TextField texto1;
    @FXML
    private TextField texto2;
    @FXML
    private TextField texto3;
    @FXML
    private TextField texto4;
    @FXML
    private TextField texto5;
    @FXML
    private TextField texto6;
    @FXML
    private TextField texto7;
    @FXML
    private TextField texto8;
    @FXML
    private Label label1;

    @FXML
    protected void VoltarJ2(ActionEvent event) throws IOException {
        Navegacao.remover();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(Navegacao.topo.fxml));
        Scene cenaAnterior = new Scene(fxmlLoader.load());
        Stage stageAtual = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        stageAtual.setScene(cenaAnterior);
        stageAtual.show();
    }

    @FXML
    public void adicionarInfo() {
        String codigo = texto1.getText();
        String nome = texto2.getText();
        String genero = texto3.getText();
        String marca = texto4.getText();
        String descricao = texto5.getText();
        double valorEntrada = Double.parseDouble(texto6.getText());
        double valorSaida = Double.parseDouble(texto7.getText());
        int quantidade = Integer.parseInt(texto8.getText());
        Jogo jogo = new Jogo(codigo, descricao, marca, valorEntrada, valorSaida, quantidade, nome, genero);
        label1.setText("JOGO ADICIONADO!");
        jogos.add(jogo);
    }


}
