package entidades;

public  abstract class Produto {


    private String codigo;
    private String descricao;
    private String marca;
    private int valorEntrada;
    private int valorSaida;
    private int qtdEstoque;
    private String nome;

    public Produto(String codigo, String descricao, String marca, int valorEntrada, int valorSaida, int qtdEstoque,
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

    public int getValorEntrada() {
        return valorEntrada;
    }

    public void setValorEntrada(int valorEntrada) {
        this.valorEntrada = valorEntrada;
    }

    public int getValorSaida() {
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
}
