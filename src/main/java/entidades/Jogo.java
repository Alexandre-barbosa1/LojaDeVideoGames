package entidades;

public class Jogo extends Produto {
    private String genero;
    public Jogo proximo;
    public double valorOriginal;
    public Jogo(String codigo, String descricao, String marca, double valorEntrada,
                double valorSaida, int qtdEstoque, String nome, String genero) {
        super(codigo, descricao, marca, valorEntrada, valorSaida, qtdEstoque, nome);
        this.genero = genero;
        this.proximo = null;
        this.valorOriginal = valorSaida;
    }

    public void setValorOriginal(double valorOriginal) {
        this.valorOriginal = valorOriginal;
    }

    public double getValorOriginal() {
        return valorOriginal;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}