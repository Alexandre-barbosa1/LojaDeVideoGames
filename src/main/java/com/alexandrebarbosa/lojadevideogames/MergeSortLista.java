package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

public class MergeSortLista {


    public Jogo mergeSort(Jogo inicio, boolean ordenarPorNome) {
        if (inicio == null || inicio.proximo == null) {
            return inicio;
        }


        Jogo meio = getMeio(inicio);
        Jogo metadeDireita = meio.proximo;
        meio.proximo = null;


        Jogo esquerda = mergeSort(inicio, ordenarPorNome);
        Jogo direita = mergeSort(metadeDireita, ordenarPorNome);


        return merge(esquerda, direita, ordenarPorNome);
    }


    private Jogo merge(Jogo lista1, Jogo lista2, boolean ordenarPorNome) {
        Jogo resultado;

        if (lista1 == null) return lista2;
        if (lista2 == null) return lista1;

        int comparacao;
        if (ordenarPorNome) {
            comparacao = lista1.getNome().compareToIgnoreCase(lista2.getNome());
        } else {
            comparacao = lista1.getCodigo().compareToIgnoreCase(lista2.getCodigo());
        }

        if (comparacao <= 0) {
            resultado = lista1;
            resultado.proximo = merge(lista1.proximo, lista2, ordenarPorNome);
        } else {
            resultado = lista2;
            resultado.proximo = merge(lista1, lista2.proximo, ordenarPorNome);
        }

        return resultado;
    }

    private Jogo getMeio(Jogo inicio) {
        if (inicio == null) return inicio;

        Jogo lento = inicio;
        Jogo rapido = inicio.proximo;

        while (rapido != null && rapido.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }
        return lento;
    }


    public void imprimirLista(Jogo inicio) {
        Jogo atual = inicio;
        while (atual != null) {
            System.out.println(atual.getNome() + " (" + atual.getCodigo() + ")");
            atual = atual.proximo;
        }
    }
}
