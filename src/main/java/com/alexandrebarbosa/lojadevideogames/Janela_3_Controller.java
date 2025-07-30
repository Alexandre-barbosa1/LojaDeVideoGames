package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.jogos;

public class Janela_3_Controller {
    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

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
        ObservableList<Jogo> dados = FXCollections.observableArrayList(jogos);
        tabelaItens.setItems(dados);
        mostrarTextoOculto(colunaCodigo);
        mostrarTextoOculto(colunaNome);
        mostrarTextoOculto(colunaGenero);
        mostrarTextoOculto(colunaMarca);
        mostrarTextoOculto(colunaDescricao);
        mostrarTextoOculto(colunaValorEntrada);
        mostrarTextoOculto(colunaValorSaida);
        mostrarTextoOculto(colunaQuantidadeEstoque);
    }


    @FXML
    public void ordenarPorCodigo(ActionEvent actionEvent) {
        MergeSortLista.mergeSortPorCodigo(jogos);
        initialize();
    }

    @FXML
    public void ordenarPorNome(ActionEvent actionEvent) {
        MergeSortLista.mergeSortPorNome(jogos);
        initialize();
    }


    private <S, T> void mostrarTextoOculto(TableColumn<S, T> coluna) {
        coluna.setCellFactory(tc -> {
            TableCell<S, T> cell = new TableCell<>();
            Tooltip tooltip = new Tooltip();

            cell.itemProperty().addListener((obs, oldValue, newValue) -> {
                if (newValue == null) {
                    cell.setText("");
                    cell.setTooltip(null);
                } else {
                    String texto = newValue.toString();
                    cell.setText(texto);
                    tooltip.setText(texto);
                    cell.setTooltip(tooltip);
                }
            });

            return cell;
        });
    }


}