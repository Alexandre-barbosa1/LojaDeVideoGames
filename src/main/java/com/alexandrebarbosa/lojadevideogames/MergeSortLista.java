package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLista {

    public static void mergeSortPorCodigo(List<Jogo> lista) {
        List<Jogo> aux = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            aux.add(null);
        }
        mergeSortPorCodigo(lista, aux, 0, lista.size() - 1);
    }

    private static void mergeSortPorCodigo(List<Jogo> lista, List<Jogo> aux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortPorCodigo(lista, aux, inicio, meio);
            mergeSortPorCodigo(lista, aux, meio + 1, fim);
            intercalarPorCodigo(lista, aux, inicio, meio, fim);
        }
    }

    private static void intercalarPorCodigo(List<Jogo> lista, List<Jogo> aux, int inicio, int meio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            aux.set(i, lista.get(i));
        }

        int esq = inicio;
        int dir = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            if (esq > meio) {
                lista.set(i, aux.get(dir++));
            } else if (dir > fim) {
                lista.set(i, aux.get(esq++));
            } else if (aux.get(esq).getCodigo().compareToIgnoreCase(aux.get(dir).getCodigo()) < 0) {
                lista.set(i, aux.get(esq++));
            } else {
                lista.set(i, aux.get(dir++));
            }
        }
    }

    public static void mergeSortPorNome(List<Jogo> lista) {
        List<Jogo> aux = new ArrayList<>();
        for (int i = 0; i < lista.size(); i++) {
            aux.add(null);
        }
        mergeSortPorNome(lista, aux, 0, lista.size() - 1);
    }

    private static void mergeSortPorNome(List<Jogo> lista, List<Jogo> aux, int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSortPorNome(lista, aux, inicio, meio);
            mergeSortPorNome(lista, aux, meio + 1, fim);
            intercalarPorNome(lista, aux, inicio, meio, fim);
        }
    }

    private static void intercalarPorNome(List<Jogo> lista, List<Jogo> aux, int inicio, int meio, int fim) {
        for (int i = inicio; i <= fim; i++) {
            aux.set(i, lista.get(i));
        }

        int esq = inicio;
        int dir = meio + 1;

        for (int i = inicio; i <= fim; i++) {
            if (esq > meio) {
                lista.set(i, aux.get(dir++));
            } else if (dir > fim) {
                lista.set(i, aux.get(esq++));
            } else if (aux.get(esq).getNome().compareToIgnoreCase(aux.get(dir).getNome()) < 0) {
                lista.set(i, aux.get(esq++));
            } else {
                lista.set(i, aux.get(dir++));
            }
        }
    }
}
