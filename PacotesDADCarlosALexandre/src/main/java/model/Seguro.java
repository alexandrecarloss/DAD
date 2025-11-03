package model;

public class Seguro {

    private Cidade local;
    private double valor;

    public Seguro() {}

    public Seguro(Cidade local, double valor) {
        this.local = local;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cidade getLocal() {
        return local;
    }

    public void setLocal(Cidade local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Seguro{" +
                "local=" + local +
                ", valor=" + valor +
                '}';
    }

}
