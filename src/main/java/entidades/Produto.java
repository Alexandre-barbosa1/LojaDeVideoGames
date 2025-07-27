package entidades;

public abstract class Produto {


    private String codigo;
    private String descricao;
    private String marca;
    private double valorEntrada;
    private double valorSaida;
    private int qtdEstoque;
    private String nome;

    public Produto(String codigo, String descricao, String marca, double valorEntrada, double valorSaida, int qtdEstoque,
                   String nome) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.marca = marca;
        this.valorEntrada = valorEntrada;
        this.valorSaida = valorSaida;
        this.qtdEstoque = qtdEstoque;
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public double getValorSaida() {
        return valorSaida;
    }

    public void setValorSaida(int valorSaida) {
        this.valorSaida = valorSaida;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", marca='" + marca + '\'' +
                ", valorEntrada=" + valorEntrada +
                ", valorSaida=" + valorSaida +
                ", qtdEstoque=" + qtdEstoque +
                ", nome='" + nome + '\'' +
                '}';
    }
}
