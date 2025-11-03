package model;

public class Voo {

    private Cidade origem;
    private Cidade destino;
    private double valor;

    public Voo(Cidade origem, Cidade destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public Voo() {}

    public Cidade getOrigem() {
        return origem;
    }

    public void setOrigem(Cidade origem) {
        this.origem = origem;
    }

    public Cidade getDestino() {
        return destino;
    }

    public void setDestino(Cidade destino) {
        this.destino = destino;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Voo{" +
                "origem=" + origem +
                ", destino=" + destino +
                ", valor=" + valor +
                '}';
    }
}
