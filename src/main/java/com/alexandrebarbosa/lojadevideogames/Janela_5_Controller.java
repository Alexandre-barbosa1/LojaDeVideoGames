package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.mostrarMensagemSucesso;
import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.pularTextField;

public class Janela_5_Controller implements Initializable {
    Jogo jogoAtual = null;
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
    private Button btEditar;

    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

    @FXML
    public void editarInfo() {
        try {
            String nome = texto2.getText();
            String genero = texto3.getText();
            String marca = texto4.getText();
            String descricao = texto5.getText();
            double valorEntrada = Double.parseDouble(texto6.getText());
            double valorSaida = Double.parseDouble(texto7.getText());
            int quantidade = Integer.parseInt(texto8.getText());
            jogoAtual.setNome(nome);
            jogoAtual.setGenero(genero);
            jogoAtual.setMarca(marca);
            jogoAtual.setDescricao(descricao);
            jogoAtual.setQuantidadeEstoque(quantidade);
            jogoAtual.setValorEntrada(valorEntrada);
            jogoAtual.setValorSaida(valorSaida);
            jogoAtual.setValorOriginal(valorSaida);
            if (testarCamposPreenchidos(nome, genero, marca, descricao)) {
                Alertas.showAlert("Erro", "Campos incompletos", "Digite todos os campos", Alert.AlertType.WARNING);
            } else {
                mostrarMensagemSucesso("JOGO EDITADO COM SUCESSO!", label1);
            }
        } catch (
                NumberFormatException e) {
            Alertas.showAlert("Erro", "Campos incompletos", "Digite todos os campos", Alert.AlertType.WARNING);
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Limitacoes.setTextFieldDouble(texto6);
        Limitacoes.setTextFieldDouble(texto7);
        Limitacoes.setTextFieldInteger(texto8);
        mostrarJogo();
        pularTextField(texto2, texto3);
        pularTextField(texto3, texto4);
        pularTextField(texto4, texto5);
        pularTextField(texto5, texto6);
        pularTextField(texto6, texto7);
        pularTextField(texto7, texto8);
        texto8.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                btEditar.fire();
                texto2.requestFocus();
                event.consume();
            }
        });
    }

    public void mostrarJogo() {
        jogoAtual = Janela_4_Controller.mostrarJogoAtual();
        texto2.setText(jogoAtual.getNome());
        texto3.setText(jogoAtual.getGenero());
        texto4.setText(jogoAtual.getMarca());
        texto5.setText(jogoAtual.getDescricao());
        texto6.setText(String.valueOf(jogoAtual.getValorEntrada()));
        texto7.setText(String.valueOf(jogoAtual.getValorSaida()));
        texto8.setText(String.valueOf(jogoAtual.getQuantidadeEstoque()));

    }

    public boolean testarCamposPreenchidos(String nome, String genero, String marca, String descricao) {
        if (nome.equalsIgnoreCase("") ||
                genero.equalsIgnoreCase("") ||
                descricao.equalsIgnoreCase("") || marca.equalsIgnoreCase("")) {
            return true;
        }
        return false;
    }
}
