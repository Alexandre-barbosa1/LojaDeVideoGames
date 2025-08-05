package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class Janela_6_Controller {
    static ObservableList<Jogo> dadosNaTabela;

    @FXML
    private TableView<Jogo> tabelaItens;
    @FXML
    private TableColumn<Jogo, String> colunaCodigo;
    @FXML
    private TableColumn<Jogo, String> colunaNome;
    @FXML
    private TableColumn<Jogo, Integer> colunaQuantidadeEstoque;
    @FXML
    private Label totalEstoque;
    @FXML
    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
        dadosNaTabela = FXCollections.observableArrayList();
        tabelaItens.setItems(dadosNaTabela);
        listaEncadeada2();
        int total = 0;
        for (Jogo jogo : dadosNaTabela) {
            total += jogo.getQuantidadeEstoque();
        }
        totalEstoque.setText("Total em estoque: " + total);
    }
    public static void listaEncadeada2() {
        dadosNaTabela.clear();
        Jogo atual = ListaJogo.inicio;
        while (atual != null) {
            dadosNaTabela.add(atual);
            atual = atual.proximo;
        }
    }
    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }
}
