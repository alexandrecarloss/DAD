package entity;


import javax.persistence.*;

@Entity
public class HotelPacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private CidadePacote local;

    @Column(nullable = false)
    private double valor;

    public HotelPacote() {}

    public HotelPacote(CidadePacote local, double valor) {
        this.local = local;
        this.valor = valor;
    }

    public CidadePacote getLocal() {
        return local;
    }

    public void setLocal(CidadePacote local) {
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
