package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

import java.util.ArrayList;
import java.util.List;

public class MergeSortLista {


    public static Jogo ordenarPorCodigo(Jogo cabeca) {
        return mergeSortPorCodigo(cabeca);
    }


    public static Jogo ordenarPorNome(Jogo cabeca) {
        return mergeSortPorNome(cabeca);
    }
    private static Jogo mergeSortPorCodigo(Jogo cabeca) {
        if (cabeca == null || cabeca.proximo == null) {
            return cabeca;
        }

        Jogo meio = encontrarMeio(cabeca);
        Jogo proximoDoMeio = meio.proximo;
        meio.proximo = null;

        Jogo metade1 = mergeSortPorCodigo(cabeca);
        Jogo metade2 = mergeSortPorCodigo(proximoDoMeio);

        return mergePorCodigo(metade1, metade2);
    }

    private static Jogo mergePorCodigo(Jogo metade1, Jogo metade2) {
        Jogo noTemporario = new Jogo();
        Jogo atual = noTemporario;

        while (metade1 != null && metade2 != null) {
            if (metade1.getCodigo().compareToIgnoreCase(metade2.getCodigo()) <= 0) {
                atual.proximo = metade1;
                metade1 = metade1.proximo;
            } else {
                atual.proximo = metade2;
                metade2 = metade2.proximo;
            }
            atual = atual.proximo;
        }

        if (metade1 != null) {
            atual.proximo = metade1;
        }
        if (metade2 != null) {
            atual.proximo = metade2;
        }
        return noTemporario.proximo;
    }


    private static Jogo mergeSortPorNome(Jogo cabeca) {
        if (cabeca == null || cabeca.proximo == null) {
            return cabeca;
        }

        Jogo meio = encontrarMeio(cabeca);
        Jogo proximoDoMeio = meio.proximo;
        meio.proximo = null;

        Jogo metade1 = mergeSortPorNome(cabeca);
        Jogo metade2 = mergeSortPorNome(proximoDoMeio);

        return mergePorNome(metade1, metade2);
    }

    private static Jogo mergePorNome(Jogo metade1, Jogo metade2) {
        Jogo noTemporario = new Jogo();
        Jogo atual = noTemporario;

        while (metade1 != null && metade2 != null) {
            if (metade1.getNome().compareToIgnoreCase(metade2.getNome()) <= 0) {
                atual.proximo = metade1;
                metade1 = metade1.proximo;
            } else {
                atual.proximo = metade2;
                metade2 = metade2.proximo;
            }
            atual = atual.proximo;
        }

        if (metade1 != null) {
            atual.proximo = metade1;
        }
        if (metade2 != null) {
            atual.proximo = metade2;
        }
        return noTemporario.proximo;
    }

    private static Jogo encontrarMeio(Jogo cabeca) {
        if (cabeca == null) {
            return null;
        }
        Jogo lento = cabeca;
        Jogo rapido = cabeca.proximo;
        while (rapido != null && rapido.proximo != null) {
            lento = lento.proximo;
            rapido = rapido.proximo.proximo;
        }
        return lento;
    }
}
