package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;
import entidades.ListaJogo;

import java.util.ArrayList;
import java.util.List;

public class Ordenar {
    public static void ordenarCodigo() {
        int t = ListaJogo.tamanho();
        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t; j++) {
                if (ListaJogo.get(i).getCodigo().compareToIgnoreCase(ListaJogo.get(j).getCodigo()) > 0) {
                    Jogo temp = new Jogo(
                            ListaJogo.get(i).getCodigo(),
                            ListaJogo.get(i).getDescricao(),
                            ListaJogo.get(i).getMarca(),
                            ListaJogo.get(i).getValorEntrada(),
                            ListaJogo.get(i).getValorSaida(),
                            ListaJogo.get(i).getQuantidadeEstoque(),
                            ListaJogo.get(i).getNome(),
                            ListaJogo.get(i).getGenero()
                    );
                    ListaJogo.set(i, ListaJogo.get(j));
                    ListaJogo.set(j, temp);
                }
            }
        }
    }
    public static void ordenarNome() {
        int t = ListaJogo.tamanho();
        for (int i = 0; i < t - 1; i++) {
            for (int j = i + 1; j < t; j++) {
                if (ListaJogo.get(i).getNome().compareToIgnoreCase(ListaJogo.get(j).getNome()) > 0) {
                    Jogo temp = new Jogo(
                            ListaJogo.get(i).getCodigo(),
                            ListaJogo.get(i).getDescricao(),
                            ListaJogo.get(i).getMarca(),
                            ListaJogo.get(i).getValorEntrada(),
                            ListaJogo.get(i).getValorSaida(),
                            ListaJogo.get(i).getQuantidadeEstoque(),
                            ListaJogo.get(i).getNome(),
                            ListaJogo.get(i).getGenero()
                    );
                    ListaJogo.set(i, ListaJogo.get(j));
                    ListaJogo.set(j, temp);
                }
            }
        }
    }
}