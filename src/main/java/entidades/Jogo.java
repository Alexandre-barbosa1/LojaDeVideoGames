package entidades;

public class Jogo extends Produto {
    private String genero;

    public Jogo(String codigo, String descricao, String marca, double valorEntrada, double valorSaida, int qtdEstoque, String nome, String genero) {
        super(codigo, descricao, marca, valorEntrada, valorSaida, qtdEstoque, nome);
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return super.toString() + "/n Genero: " + genero;
    }
}
