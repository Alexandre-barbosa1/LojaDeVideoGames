package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.jogos;

public class Janela_4_Controller {
    List<Jogo> listaParaTabela = new ArrayList<>();

    @FXML
    protected void VoltarJ3(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

    @FXML
    private TextField texto1;
    @FXML
    private TableView<Jogo> tabelaItens;
    @FXML
    private TableColumn<Jogo, String> colunaCodigo;
    @FXML
    private TableColumn<Jogo, String> colunaNome;
    @FXML
    private TableColumn<Jogo, String> colunaGenero;
    @FXML
    private TableColumn<Jogo, String> colunaMarca;
    @FXML
    private TableColumn<Jogo, String> colunaDescricao;
    @FXML
    private TableColumn<Jogo, Double> colunaValorEntrada;
    @FXML
    private TableColumn<Jogo, Double> colunaValorSaida;
    @FXML
    private TableColumn<Jogo, Integer> colunaQuantidadeEstoque;

    @FXML
    public void initialize() {
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaValorEntrada.setCellValueFactory(new PropertyValueFactory<>("valorEntrada"));
        colunaValorSaida.setCellValueFactory(new PropertyValueFactory<>("valorSaida"));
        colunaQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
    }

    @FXML
    public void buscarPorCodigo() {
        String codigo = texto1.getText();
        listaParaTabela.clear();
        limpar();
        if (BuscaBinaria.buscaBinariaCodigo(codigo)) {
            Jogo jogoBuscado = BuscaBinaria.mostrarJogoPorCodigo();
            listaParaTabela.add(jogoBuscado);
            ObservableList<Jogo> dadosNaTabela = FXCollections.observableArrayList(listaParaTabela);
            tabelaItens.setItems(dadosNaTabela);
        } else {
            Alertas.showAlert("Erro", "Código não encontrado", "Digite um código válido", Alert.AlertType.WARNING);

        }

    }

    @FXML
    public void buscarPorNome() {
        String nome = texto1.getText();
        listaParaTabela.clear();
        limpar();
        if (BuscaBinaria.buscaBinariaNome(nome)) {
            Jogo jogoBuscado = BuscaBinaria.mostrarJogoPorNome();
            listaParaTabela.add(jogoBuscado);
            ObservableList<Jogo> dadosNaTabela = FXCollections.observableArrayList(listaParaTabela);
            tabelaItens.setItems(dadosNaTabela);
        } else {
            Alertas.showAlert("Erro", "Nome não encontrado", "Digite um nome válido", Alert.AlertType.WARNING);

        }

    }

    public void limpar() {
        tabelaItens.setItems(FXCollections.observableArrayList());
    }


}



