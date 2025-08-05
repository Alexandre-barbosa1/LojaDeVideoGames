package entidades;

public class ListaVendas {
    public static RelatorioVendas inicio = null;
    static RelatorioVendas fim = null;

    public void adicionarInicio(RelatorioVendas novo) {
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio = novo;
        }
    }

    public void adicionarFim(RelatorioVendas novo) {
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }
    public RelatorioVendas get(int indice) {
        RelatorioVendas aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == indice) return aux;
            contador++;
            aux = aux.proximo;
        }
        return null;
    }
    public void set(int indice, RelatorioVendas novo) {
        RelatorioVendas aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == indice) {
                aux.setCodigoVendas(novo.getCodigoVendas());
                aux.setQuantidadeVendas(novo.getQuantidadeVendas());
                aux.setNomeVenda(novo.getNomeVenda());
                aux.setMontante(novo.getMontante());
                return;
            }
            contador++;
            aux = aux.proximo;
        }
    }
    public int tamanho() {
        int count = 0;
        RelatorioVendas aux = inicio;
        while (aux != null) {
            count++;
            aux = aux.proximo;
        }
        return count;
    }

}
