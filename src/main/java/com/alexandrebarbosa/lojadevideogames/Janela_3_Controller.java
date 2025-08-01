package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.jogos;

public class Janela_3_Controller {

    public static List<Jogo> jogosOriginal = new ArrayList<>();


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
    private RadioButton rbtPrecoOriginal;
    @FXML
    private RadioButton rbtPrecoAtual;
    @FXML
    private RadioButton rbtDesconto;
    @FXML
    private RadioButton rbtAumento;
    @FXML
    private RadioButton rbtPercentual;
    @FXML
    private RadioButton rbtFixo;
    @FXML
    private TextField textValor;
    @FXML
    private Label textAplicarSobre;

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

        if (jogosOriginal.isEmpty()) {
            jogosOriginal = jogos;
        }
        rbtPrecoOriginal.setDisable(true);
        rbtPrecoAtual.setDisable(true);
        rbtPrecoOriginal.setStyle("-fx-text-fill: gray;");
        rbtPrecoAtual.setStyle("-fx-text-fill: gray;");
        textAplicarSobre.setStyle("-fx-text-fill: gray;");
        rbtPercentual.setOnAction(e -> habilitarTipoAjuste());
        rbtFixo.setOnAction(e -> habilitarTipoAjuste());
        textValor.clear();
        rbtDesconto.setSelected(false);
        rbtAumento.setSelected(false);
        rbtFixo.setSelected(false);
        rbtPercentual.setSelected(false);
        rbtPrecoAtual.setSelected(false);
        rbtPrecoOriginal.setSelected(false);
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

    @FXML
    public void btAplicarAjuste(ActionEvent actionEvent) {
        double valorAjuste = Double.parseDouble(textValor.getText());
        for (int i = 0; i < jogos.size(); i++) {
            double escolha = jogos.get(i).getValorSaida();
            double novoValor = escolha;
            if (rbtPrecoOriginal.isSelected()) {
                escolha = jogosOriginal.get(i).getValorSaida();
                novoValor = escolha;
            }
            if (rbtDesconto.isSelected() && rbtPercentual.isSelected()) {
                novoValor = escolha - ((valorAjuste / 100) * escolha);
            } else if (rbtDesconto.isSelected() && rbtFixo.isSelected()) {
                novoValor = escolha - valorAjuste;
            } else if (rbtAumento.isSelected() && rbtPercentual.isSelected()) {
                novoValor = escolha + ((valorAjuste / 100) * escolha);
            } else if (rbtAumento.isSelected() && rbtFixo.isSelected()) {
                novoValor = escolha + valorAjuste;
            }
            jogos.get(i).setValorSaida(novoValor);
        }
        tabelaItens.refresh();
    }

    @FXML
    public void btLimparAjustes(ActionEvent actionEvent) {
        for (int i = 0; i < jogos.size(); i++) {
            jogos.get(i).setValorSaida(jogosOriginal.get(i).getValorSaida());
        }
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

    private void habilitarTipoAjuste() {
        boolean ativado = rbtPercentual.isSelected();

        rbtPrecoOriginal.setDisable(!ativado);
        rbtPrecoAtual.setDisable(!ativado);

        if (ativado) {
            rbtPrecoOriginal.setStyle("-fx-text-fill: black;");
            rbtPrecoAtual.setStyle("-fx-text-fill: black;");
            textAplicarSobre.setStyle("-fx-text-fill: black;");
        } else {
            rbtPrecoOriginal.setStyle("-fx-text-fill: gray;");
            rbtPrecoAtual.setStyle("-fx-text-fill: gray;");
            textAplicarSobre.setStyle("-fx-text-fill: gray;");
        }
        if (!ativado) {
            rbtPrecoAtual.setSelected(false);
            rbtPrecoOriginal.setSelected(false);
        }
    }
}