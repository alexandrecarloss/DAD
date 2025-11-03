package model;

public class Reserva {

    private Cidade destino;
    private double valor;

    public Reserva() {}

    public Reserva(Cidade destino, double valor) {
        this.destino = destino;
        this.valor = valor;
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
        return "Reserva{" +
                "destino=" + destino +
                ", valor=" + valor +
                '}';
    }
}
