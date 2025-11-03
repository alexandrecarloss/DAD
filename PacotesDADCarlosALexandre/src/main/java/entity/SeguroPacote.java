package entity;

import javax.persistence.*;

@Entity
public class SeguroPacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private CidadePacote local;

    @Column(nullable = false)
    private double valor;

    public SeguroPacote() {}

    public SeguroPacote(CidadePacote local, double valor) {
        this.local = local;
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public CidadePacote getLocal() {
        return local;
    }

    public void setLocal(CidadePacote local) {
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
