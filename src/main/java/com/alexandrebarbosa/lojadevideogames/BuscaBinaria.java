package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

import java.util.Locale;

import static com.alexandrebarbosa.lojadevideogames.Janela_2_Controller.jogos;

public class BuscaBinaria {
    public static Jogo ultimoJogoCodigo = null;
    public static Jogo ultimoJogoNome = null;
    public  static int indice = 0;

    public static boolean buscaBinariaCodigo(String codigo) {
        ultimoJogoCodigo = null;
        MergeSortLista.mergeSortPorCodigo(jogos);
        int inicio = 0;
        int fim = jogos.size() - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            String valorMedio = jogos.get(meio).getCodigo();
            if (valorMedio.compareToIgnoreCase(codigo) == 0) {
                ultimoJogoCodigo = jogos.get(meio);
                return true;
            } else if (valorMedio.compareTo(codigo) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }


    public static Jogo mostrarJogoPorCodigo() {
        return ultimoJogoCodigo;
    }


    public static boolean buscaBinariaNome(String nome) {
        ultimoJogoNome = null;
        MergeSortLista.mergeSortPorNome(jogos);
        int inicio = 0;
        int fim = jogos.size() - 1;
        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            String valorMedio = jogos.get(meio).getNome();
            if (valorMedio.compareToIgnoreCase(nome) == 0) {
                ultimoJogoNome = jogos.get(meio);
                indice = meio;
                return true;
            } else if (valorMedio.compareTo(nome) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }

    public static Jogo mostrarJogoPorNome() {
        return ultimoJogoNome;
    }

    public static int mostrarIndice() {
        return indice;
    }
}
