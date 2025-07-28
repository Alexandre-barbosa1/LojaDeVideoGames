package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

import java.util.List;

public class BuscaBinaria {
    public static boolean buscaBinariaCodigo(List<Jogo> lista, String codigo) {
        int inicio = 0;
        int fim = lista.size() - 1;

        while (inicio <= fim) {
            int meio = inicio + (fim - inicio) / 2;
            String valorMedio = lista.get(meio).getCodigo();
            if (valorMedio.compareTo(codigo) == 0) {
                return true;
            } else if (valorMedio.compareTo(codigo) < 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        return false;
    }
}
