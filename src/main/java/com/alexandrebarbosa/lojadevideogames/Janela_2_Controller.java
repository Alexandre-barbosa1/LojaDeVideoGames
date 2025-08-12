package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Janela_2_Controller implements Initializable {

    public ListaJogo listaJogos = new ListaJogo();
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
    private Button btAdicionar;

    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
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
            if (ListaJogo.testarSeExisteCodigo(codigo)) {
                Alertas.showAlert("Erro", "Codigo ja inserido", "Digite um código válido", Alert.AlertType.WARNING);
                limpar();
            } else {
                listaJogos.adicionarInicio(jogo);
                mostrarMensagemSucesso("JOGO ADICIONADO COM SUCESSO!", label1);
                if (Historico.test % 2 != 0) {
                    Historico.inverter();
                }
                Historico.add(new Jogo(
                        jogo.getCodigo(),
                        jogo.getDescricao(),
                        jogo.getMarca(),
                        jogo.getValorEntrada(),
                        jogo.getValorSaida(),
                        jogo.getQuantidadeEstoque(),
                        jogo.getNome(),
                        jogo.getGenero()
                ));
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
        pularTextField(texto1, texto2);
        pularTextField(texto2, texto3);
        pularTextField(texto3, texto4);
        pularTextField(texto4, texto5);
        pularTextField(texto5, texto6);
        pularTextField(texto6, texto7);
        pularTextField(texto7, texto8);
        texto8.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                btAdicionar.fire();
                texto1.requestFocus();
                event.consume();
            }
        });

    }

    public static void pularTextField(TextField texto, TextField proxTexto) {
        texto.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                proxTexto.requestFocus();
                event.consume();
            }
        });
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


    public static void mostrarMensagemSucesso(String mensagem, Label label) {
        label.setText(mensagem);
        label.setOpacity(1.0);

        FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), label);
        fadeOut.setFromValue(1.0);
        fadeOut.setToValue(0.0);

        fadeOut.play();
    }
}
