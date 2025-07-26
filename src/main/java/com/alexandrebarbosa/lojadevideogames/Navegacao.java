package com.alexandrebarbosa.lojadevideogames;

public class Navegacao {
    public static class Bloco {
        public String fxml;
        public Bloco ant;

        public Bloco(String fxml) {
            this.fxml = fxml;
            this.ant = null;
        }
    }

    public static Bloco topo = new Bloco("Janela-1.fxml");

    public static void add(String caminho) {
        Bloco novo = new Bloco(caminho);
        novo.ant = topo;
        topo = novo;
    }

    public static void remover() {
        if (topo == null) {
            return;
        } else {
            topo = topo.ant;
        }
    }
}