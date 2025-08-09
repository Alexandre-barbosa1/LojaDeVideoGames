package com.alexandrebarbosa.lojadevideogames;

import entidades.Jogo;

public class Historico {
    public static Jogo inicio = null;
    public static Jogo fim = null;

    public static void add(Jogo novo) {
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    static int test = 0;

    public static void inverter() {
        if (inicio == null || inicio.proximo == null) {
            return;
        }
        Jogo anterior = null;
        Jogo atual = inicio;
        Jogo proximo;
        while (atual != null) {
            proximo = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = proximo;
        }
        inicio = anterior;
        test++;
    }
}