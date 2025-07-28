package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Janela_2_Controller implements Initializable {

    public static List<Jogo> jogos = new ArrayList<>();
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
    private Button botao1;

    @FXML
    protected void VoltarJ2(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

    @FXML
    public void adicionarInfo() {
        try {
            texto1.setOnMouseClicked(event -> {
                label1.setText("");
            });
            String codigo = texto1.getText();
            String nome = texto2.getText();
            String genero = texto3.getText();
            String marca = texto4.getText();
            String descricao = texto5.getText();
            double valorEntrada = Double.parseDouble(texto6.getText());
            double valorSaida = Double.parseDouble(texto7.getText());
            int quantidade = Integer.parseInt(texto8.getText());
            Jogo jogo = new Jogo(codigo, descricao, marca, valorEntrada, valorSaida, quantidade, nome, genero);
            if (BuscaBinaria.buscaBinariaCodigo(jogos, codigo)) {
                Alertas.showAlert("Erro", "Codigo ja inserido", "Digite um código válido", Alert.AlertType.WARNING);
                limpar();
            } else {
                jogos.add(jogo);
                label1.setText("JOGO ADICIONADO!");
                limpar();
            }
        } catch (NumberFormatException e) {
            Alertas.showAlert("Erro", "Campos incompletos", "Digite todos os campos", Alert.AlertType.WARNING);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Limitacoes.setTextFieldDouble(texto6);
        Limitacoes.setTextFieldDouble(texto7);
        Limitacoes.setTextFieldInteger(texto8);


    }

    public void limpar() {
        texto1.clear();
        texto2.clear();
        texto3.clear();
        texto4.clear();
        texto5.clear();
        texto6.clear();
        texto7.clear();
        texto8.clear();
    }
}
