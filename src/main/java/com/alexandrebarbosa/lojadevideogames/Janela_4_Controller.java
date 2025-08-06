package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;
import entidades.ListaVendas;
import entidades.RelatorioVendas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Janela_4_Controller {
    static Jogo jogoBuscado = null;
    public ListaVendas listaVendas = new ListaVendas();
    public ListaJogo listaJogo = new ListaJogo();

    @FXML
    protected void Voltar(ActionEvent event) throws IOException {
        Navegacao.remover();
        Navegacao.caminho(event);
    }

    @FXML
    private Button btnBuscarNome;
    @FXML
    private Button btnBuscarCodigo;

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
    private TextField texto2;

    @FXML
    private TextField texto3;


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
        limpar();
        String codigo = texto1.getText();
        jogoBuscado = ListaJogo.buscarjogoPorCodigo(codigo);
        if (jogoBuscado == null) {
            Alertas.showAlert("Erro", "Codigo não encontrado", "Digite um codigo  válido", Alert.AlertType.WARNING);
        } else {
            ObservableList<Jogo> dadosNaTabela = FXCollections.observableArrayList(jogoBuscado);
            tabelaItens.setItems(dadosNaTabela);
        }
    }

    @FXML
    public void buscarPorNome() {
        limpar();
        String nome = texto1.getText();
        jogoBuscado = ListaJogo.buscarjogoPorNome(nome);
        if (jogoBuscado == null) {
            Alertas.showAlert("Erro", "Nome não encontrado", "Digite um nome válido", Alert.AlertType.WARNING);
        } else {
            ObservableList<Jogo> dadosNaTabela = FXCollections.observableArrayList(jogoBuscado);
            tabelaItens.setItems(dadosNaTabela);
        }
    }

    @FXML
    protected void btEditarJogo(ActionEvent event) throws IOException {
        if (texto1.getText().equalsIgnoreCase("")) {
            Alertas.showAlert("Erro", "Nome não encontrado", "Digite um nome válido", Alert.AlertType.WARNING);
        } else {
            limpar();

            Navegacao.add("Janela-5.fxml");
            Navegacao.caminho(event);
        }
    }

    @FXML
    protected void btVenderJogo(ActionEvent event) throws IOException {
        try {
            if (jogoBuscado == null) {
                Alertas.showAlert("Erro", "Nenhum Jogo Selecionado", "Por favor, busque e selecione um jogo primeiro.", Alert.AlertType.WARNING);
                return;
            }
            int quantEscolhida = Integer.parseInt(texto2.getText());
            if (quantEscolhida <= 0) {
                Alertas.showAlert("Erro", "Quantidade Inválida", "A quantidade a ser vendida deve ser maior que zero.", Alert.AlertType.WARNING);
                return;
            }
            if (jogoBuscado.getQuantidadeEstoque() < quantEscolhida) {
                Alertas.showAlert("Erro", "Estoque Insuficiente", "Não há quantidade suficiente em estoque.", Alert.AlertType.WARNING);
                return;
            }
            int novoEstoque = jogoBuscado.getQuantidadeEstoque() - quantEscolhida;
            jogoBuscado.setQuantidadeEstoque(novoEstoque);
            tabelaItens.refresh();
            double valorsaida = jogoBuscado.getValorSaida();
            double montante = quantEscolhida * valorsaida;
            String nome = jogoBuscado.getNome();
            String codiguim = jogoBuscado.getCodigo();
            RelatorioVendas relatorio = new RelatorioVendas(nome, quantEscolhida, montante, codiguim);
            if (listaVendas.tamanho() == 0) {
                listaVendas.adicionarInicio(relatorio);
            } else {
                boolean itemEncontrado = false;
                for (int i = 0; i < listaVendas.tamanho(); i++) {
                    RelatorioVendas itemDaLista = listaVendas.get(i);
                    if (codiguim.equals(itemDaLista.getCodigoVendas())) {
                        int novaQuantidade = itemDaLista.getQuantidadeVendas() + quantEscolhida;
                        double novoMontante = itemDaLista.getMontante() + montante;

                        RelatorioVendas relatorioAtualizado = new RelatorioVendas(nome, novaQuantidade, novoMontante, codiguim);
                        listaVendas.set(i, relatorioAtualizado);

                        itemEncontrado = true;
                        break;
                    }
                }
                if (!itemEncontrado) {
                    listaVendas.adicionarInicio(relatorio);
                }
            }


        } catch (NumberFormatException e) {
            Alertas.showAlert("Erro", "Campo de Quantidade Inválido", "Por favor, digite uma quantidade numérica válida.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void limpar() {
        tabelaItens.setItems(FXCollections.observableArrayList());
    }

    public static Jogo mostrarJogoAtual() {
        return jogoBuscado;
    }

    @FXML
    protected void btReporJogo(ActionEvent event) throws IOException {

        try {
            int quantEscolhida = Integer.parseInt(texto3.getText());
            if (jogoBuscado == null) {
                Alertas.showAlert("Erro", "Nenhum Jogo Selecionado", "Por favor, busque e selecione um jogo primeiro.", Alert.AlertType.WARNING);
                return;
            }
            if (quantEscolhida <= 0) {
                Alertas.showAlert("Erro", "Quantidade Inválida", "A quantidade a ser vendida deve ser maior que zero.", Alert.AlertType.WARNING);
                return;
            }
            jogoBuscado.setQuantidadeEstoque(quantEscolhida + jogoBuscado.getQuantidadeEstoque());
            tabelaItens.refresh();
        } catch (NumberFormatException e) {
            Alertas.showAlert("Erro", "Campo de Quantidade Inválido", "Por favor, digite uma quantidade numérica válida.", Alert.AlertType.WARNING);

        }
    }

    @FXML
    protected void btExcluirJogo() {
        if (jogoBuscado == null) {
            Alertas.showAlert("Erro", "Nenhum Jogo Selecionado", "Por favor, busque e selecione um jogo para excluir.", Alert.AlertType.WARNING);
            return;
        }
        String codigoParaExcluir = jogoBuscado.getCodigo();
        listaJogo.excluir(codigoParaExcluir);
        limpar();
        jogoBuscado = null;
    }
}


