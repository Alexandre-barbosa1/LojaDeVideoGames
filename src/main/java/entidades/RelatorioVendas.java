package entidades;

public class RelatorioVendas {
    public RelatorioVendas proximo;
    private String nomeVenda;
    private int quantidadeVendas;
    private double montante;
    private String codigoVendas;

    public RelatorioVendas(String nomeVenda, int quantidadeVendas, double montante,  String codigoVendas) {
        this.nomeVenda = nomeVenda;
        this.quantidadeVendas = quantidadeVendas;
        this.montante = montante;
        this.codigoVendas = codigoVendas;
        this.proximo = null;
    }

    public String getNomeVenda() {
        return nomeVenda;
    }

    public void setNomeVenda(String nome) {
        this.nomeVenda = nome;
    }

    public int getQuantidadeVendas() {
        return quantidadeVendas;
    }

    public void setQuantidadeVendas(int quantidadeVendas) {
        this.quantidadeVendas = quantidadeVendas;
    }

    public double getMontante() {
        return montante;
    }

    public void setMontante(double montante) {
        this.montante = montante;
    }
    public String getCodigoVendas() {
        return codigoVendas;
    }
    public void setCodigoVendas(String codigoVendas) {
        this.codigoVendas = codigoVendas;
    }
}
