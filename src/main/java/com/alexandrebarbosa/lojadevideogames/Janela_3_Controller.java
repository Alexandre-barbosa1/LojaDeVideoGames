package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class Janela_3_Controller {

    static ObservableList<Jogo> dadosNaTabela;
    public ListaJogo listaJogo;
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
    private RadioButton rbtDesconto;
    @FXML
    private RadioButton rbtAcrescimo;
    @FXML
    private TextField textValor;
    @FXML
    private Label lbAjusteAp;

    @FXML
    public void initialize() {
        listaJogo = new ListaJogo();
        colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaGenero.setCellValueFactory(new PropertyValueFactory<>("genero"));
        colunaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<>("descricao"));
        colunaValorEntrada.setCellValueFactory(new PropertyValueFactory<>("valorEntrada"));
        colunaValorSaida.setCellValueFactory(new PropertyValueFactory<>("valorSaida"));
        colunaQuantidadeEstoque.setCellValueFactory(new PropertyValueFactory<>("quantidadeEstoque"));

        dadosNaTabela = FXCollections.observableArrayList();
        tabelaItens.setItems(dadosNaTabela);

        listaEncadeada();

        mostrarTextoOculto(colunaCodigo);
        mostrarTextoOculto(colunaNome);
        mostrarTextoOculto(colunaGenero);
        mostrarTextoOculto(colunaMarca);
        mostrarTextoOculto(colunaDescricao);
        mostrarTextoOculto(colunaValorEntrada);
        mostrarTextoOculto(colunaValorSaida);
        mostrarTextoOculto(colunaQuantidadeEstoque);
        textValor.clear();
        rbtDesconto.setSelected(false);
        rbtAcrescimo.setSelected(false);
        lbAjusteAp.setText(textaj);
    }

    public static void listaEncadeada() {
        dadosNaTabela.clear();
        Jogo atual = ListaJogo.inicio;
        while (atual != null) {
            dadosNaTabela.add(atual);
            atual = atual.proximo;
        }
    }

    @FXML
    public void ordenarPorCodigo(ActionEvent actionEvent) {
        listaJogo.ordenarPorCodigo();
        listaEncadeada();
        tabelaItens.refresh();
    }

    @FXML
    public void ordenarPorNome(ActionEvent actionEvent) {
        listaJogo.ordenarPorNome();
        listaEncadeada();
        tabelaItens.refresh();
    }
    static String textaj = "Ajuste aplicado: 0%";
    @FXML
    public void btAplicarAjuste(ActionEvent actionEvent) {
        try {
            Jogo aux = ListaJogo.inicio;
            double valorAjuste = Double.parseDouble(textValor.getText());
            if(!rbtDesconto.isSelected() && !rbtAcrescimo.isSelected()) {
                Alertas.showAlert("Erro", "Campos incompletos", "Digite o ajusto e marque a opção desejada", Alert.AlertType.WARNING);
            }
            if (rbtDesconto.isSelected()) {
                textaj = "Ajuste aplicado: -" + valorAjuste + "%";
                while (aux != null) {
                    double original = aux.getValorOriginal() - (aux.getValorOriginal() * (valorAjuste / 100));
                    aux.setValorSaida(original);
                    aux = aux.proximo;
                }
            } else if (rbtAcrescimo.isSelected()) {
                textaj = "Ajuste aplicado: +" + valorAjuste + "%";
                while (aux != null) {
                    double original = aux.getValorOriginal() + (aux.getValorOriginal() * (valorAjuste / 100));
                    aux.setValorSaida(original);
                    aux = aux.proximo;
                }
            }
            lbAjusteAp.setText(textaj);
            tabelaItens.refresh();
        } catch(Exception e) {
            Alertas.showAlert("Erro", "Campos incompletos", "Digite o ajusto e marque a opção desejada", Alert.AlertType.WARNING);
            }
        textValor.clear();
        rbtDesconto.setSelected(false);
        rbtAcrescimo.setSelected(false);
    }

    @FXML
    public void btLimparAjustes(ActionEvent actionEvent) {
        textValor.clear();
        rbtDesconto.setSelected(false);
        rbtAcrescimo.setSelected(false);
        Jogo aux = ListaJogo.inicio;
        while (aux != null) {
            aux.setValorSaida(aux.getValorOriginal());
            aux = aux.proximo;
        }
        textaj = "Ajuste aplicado: 0%";
        lbAjusteAp.setText(textaj);
        tabelaItens.refresh();
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