package entidades;

import com.alexandrebarbosa.lojadevideogames.Alertas;
import javafx.scene.control.Alert;

public class ListaJogo {
    public static Jogo inicio = null;
    static Jogo fim = null;

    public void adicionarInicio(Jogo novo) {
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.proximo = inicio;
            inicio = novo;
        }
    }

    public void adicionarFim(Jogo novo) {
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            fim.proximo = novo;
            fim = novo;
        }
    }

    public void mostrarLista() {
        Jogo aux = inicio;
        if (aux == null) {
            Alertas.showAlert("Erro", "lista vazia", "a lista está vazia", Alert.AlertType.WARNING);
        } else {
            while (aux != null) {
                System.out.println(aux);
                aux = aux.proximo;
            }
        }
    }

    public static Jogo buscarjogoPorCodigo(String codigo) {
        Jogo aux = inicio;
        if (inicio == null) {
            return null;
        } else {
            while (aux != null) {
                if (aux.getCodigo().equalsIgnoreCase(codigo)) {
                    return aux;
                }
                aux = aux.proximo;
            }
        }
        return null;
    }

    public static Jogo buscarjogoPorNome(String codigo) {
        Jogo aux = inicio;
        if (inicio == null) {

            return null;
        } else {
            while (aux != null) {
                if (aux.getNome().equalsIgnoreCase(codigo)) {
                    return aux;
                }
                aux = aux.proximo;
            }
        }
        return null;
    }

    public static boolean testarSeExisteCodigo(String codigo) {
        Jogo aux = inicio;
        while (aux != null) {
            if (aux.getCodigo().equalsIgnoreCase(codigo)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public static Jogo get(int indice) {
        Jogo aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == indice) return aux;
            contador++;
            aux = aux.proximo;
        }
        return null;
    }

    public static void set(int indice, Jogo novo) {
        Jogo aux = inicio;
        int contador = 0;
        while (aux != null) {
            if (contador == indice) {
                aux.setCodigo(novo.getCodigo());
                aux.setDescricao(novo.getDescricao());
                aux.setMarca(novo.getMarca());
                aux.setValorEntrada(novo.getValorEntrada());
                aux.setValorSaida(novo.getValorSaida());
                aux.setQuantidadeEstoque(novo.getQuantidadeEstoque());
                aux.setNome(novo.getNome());
                aux.setGenero(novo.getGenero());
                return;
            }
            contador++;
            aux = aux.proximo;
        }
    }

    public static int tamanho() {
        int count = 0;
        Jogo aux = inicio;
        while (aux != null) {
            count++;
            aux = aux.proximo;
        }
        return count;
    }

    public void excluir(String codigoParaExcluir) {
        if (inicio == null) {
            Alertas.showAlert("Erro", "Lista Vazia", "A lista está vazia. Não há nada para excluir.", Alert.AlertType.WARNING);
            return;
        }
        if (inicio.getCodigo().equalsIgnoreCase(codigoParaExcluir)) {
            inicio = inicio.proximo;
            if (inicio == null) {
                fim = null;
            }
            Alertas.showAlert("Sucesso", "Remoção Concluída", "O jogo com o código '" + codigoParaExcluir + "' foi removido com sucesso.", Alert.AlertType.INFORMATION);
            return;
        }

        Jogo anterior = inicio;
        Jogo atual = inicio.proximo;

        while (atual != null) {
            if (atual.getCodigo().equalsIgnoreCase(codigoParaExcluir)) {
                anterior.proximo = atual.proximo;
                if (anterior.proximo == null) {
                    fim = anterior;
                }
                Alertas.showAlert("Sucesso", "Remoção Concluída", "O jogo com o código '" + codigoParaExcluir + "' foi removido com sucesso.", Alert.AlertType.INFORMATION);
                return;
            }
            anterior = atual;
            atual = atual.proximo;
        }
        Alertas.showAlert("Erro", "Jogo Não Encontrado", "O jogo com o código '" + codigoParaExcluir + "' não foi encontrado na lista.", Alert.AlertType.ERROR);
    }
}