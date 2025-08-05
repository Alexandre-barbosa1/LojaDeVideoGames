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
      public static void remove() {
              inicio = null;
              fim = null;
          }
      }


