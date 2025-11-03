package model;

public class Hotel {

    private Cidade local;
    private double valor;

    public Hotel() {}

    public Hotel(Cidade local, double valor) {
        this.local = local;
        this.valor = valor;
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
        return "Hotel{" +
                "local=" + local +
                ", valor=" + valor +
                '}';
    }
}
