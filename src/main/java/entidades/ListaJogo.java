package entidades;

import com.alexandrebarbosa.lojadevideogames.Alertas;
import javafx.scene.control.Alert;

public class ListaJogo {
    static Jogo inicio = null;
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


}
