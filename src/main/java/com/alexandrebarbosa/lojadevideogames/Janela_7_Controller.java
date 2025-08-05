package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;
import entidades.ListaVendas;
import entidades.RelatorioVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;


public class Janela_7_Controller {
    public ListaVendas listaVendas = new ListaVendas();
    static ObservableList<RelatorioVendas> dadosVendas;
    @FXML
    private TableView<RelatorioVendas> tabelaVendas;
    @FXML
    private TableColumn<RelatorioVendas, String> colunaNomeVendas;
    @FXML
    private TableColumn<RelatorioVendas, Integer> colunaQuantidadeVendas;
    @FXML
    private TableColumn<RelatorioVendas, Double> colunaMontante;
    @FXML
    private TableColumn<RelatorioVendas, String> colunaCodigoVendas;
    @FXML
    private Label totalVendas;
    @FXML
    private Label totalMontante;

    @FXML
    public void initialize() {
        colunaNomeVendas.setCellValueFactory(new PropertyValueFactory<>("nomeVenda"));
        colunaQuantidadeVendas.setCellValueFactory(new PropertyValueFactory<>("quantidadeVendas"));
        colunaMontante.setCellValueFactory(new PropertyValueFactory<>("montante"));
        colunaCodigoVendas.setCellValueFactory(new PropertyValueFactory<>("codigoVendas"));
        dadosVendas = FXCollections.observableArrayList();
        tabelaVendas.setItems(dadosVendas);

        listaEncadeada3();
        int vendas = 0;
        double vendasMontante = 0;
        for (RelatorioVendas v : dadosVendas) {
            vendas += v.getQuantidadeVendas();
            vendasMontante += v.getMontante();
        }
        totalVendas.setText("Total de vendas: " + vendas);
        totalMontante.setText("Montante total: R$ " + vendasMontante);
    }

    public static void listaEncadeada3() {
        dadosVendas.clear();
        RelatorioVendas atual = ListaVendas.inicio;
        while (atual != null) {
            dadosVendas.add(atual);
            atual = atual.proximo;
        }
    }
    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }
}
