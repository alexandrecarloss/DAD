package entity;

import javax.persistence.*;

@Entity
public class ReservaPacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private CidadePacote destino;

    @Column(nullable = false)
    private double valor;

    public ReservaPacote() {}

    public ReservaPacote(CidadePacote destino, double valor) {
        this.destino = destino;
        this.valor = valor;
    }

    public CidadePacote getDestino() {
        return destino;
    }

    public void setDestino(CidadePacote destino) {
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
