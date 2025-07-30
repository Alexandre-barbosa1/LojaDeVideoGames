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

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.jogos;

public class Janela_5_Controller implements Initializable {
    int indice = BuscaBinaria.mostrarIndice();
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
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

    @FXML
    public void editarInfo() {
        try {
            indice = BuscaBinaria.mostrarIndice();
            String nome = texto2.getText();
            String genero = texto3.getText();
            String marca = texto4.getText();
            String descricao = texto5.getText();
            double valorEntrada = Double.parseDouble(texto6.getText());
            double valorSaida = Double.parseDouble(texto7.getText());
            int quantidade = Integer.parseInt(texto8.getText());
            jogos.get(indice).setNome(nome);
            jogos.get(indice).setGenero(genero);
            jogos.get(indice).setMarca(marca);
            jogos.get(indice).setDescricao(descricao);
            jogos.get(indice).setQuantidadeEstoque(quantidade);
            jogos.get(indice).setValorEntrada(valorEntrada);
            jogos.get(indice).setValorSaida(valorSaida);
            label1.setText("JOGO editado com sucesso!");
            limpar();
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
    }

    public void limpar() {
        texto2.clear();
        texto3.clear();
        texto4.clear();
        texto5.clear();
        texto6.clear();
        texto7.clear();
        texto8.clear();
    }

    public void mostrarJogo() {
        texto2.setText(jogos.get(indice).getNome());
        texto3.setText(jogos.get(indice).getGenero());
        texto4.setText(jogos.get(indice).getMarca());
        texto5.setText(jogos.get(indice).getDescricao());
        texto6.setText(String.valueOf(jogos.get(indice).getValorEntrada()));
        texto7.setText(String.valueOf(jogos.get(indice).getValorSaida()));
        texto8.setText(String.valueOf(jogos.get(indice).getQuantidadeEstoque()));

    }
}
