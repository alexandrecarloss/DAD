package model;

public class Locacao {

    private Cidade local;
    private double valor;

    public Locacao(Cidade local, double valor) {
        this.local = local;
        this.valor = valor;
    }

    public Locacao() {
    }

    public Cidade getLocal() {
        return local;
    }

    public void setLocal(Cidade local) {
        this.local = local;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Locacao{" +
                "local=" + local +
                ", valor=" + valor +
                '}';
    }
}
