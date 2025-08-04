package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class Janela_7_Controller {

    @FXML
    private TableView<Jogo> tabelaItens;
    @FXML
    private TableColumn<Jogo, String> colunaNome;
    @FXML
    private TableColumn<Jogo, Integer> colunaQuantidadeEstoque;
    @FXML
    private Label totalEstoque;

    @FXML
    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));
        totalEstoque.setText("Total de estoque: ");
    }

    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }
}
