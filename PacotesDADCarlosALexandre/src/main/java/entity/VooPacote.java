package entity;

import javax.persistence.*;

@Entity
public class VooPacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private CidadePacote origem;

    @ManyToOne
    private CidadePacote destino;

    @Column(nullable = false)
    private double valor;

    public VooPacote(CidadePacote origem, CidadePacote destino, double valor) {
        this.origem = origem;
        this.destino = destino;
        this.valor = valor;
    }

    public VooPacote() {}

    public CidadePacote getOrigem() {
        return origem;
    }

    public void setOrigem(CidadePacote origem) {
        this.origem = origem;
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
        return "Voo{" +
                "origem=" + origem +
                ", destino=" + destino +
                ", valor=" + valor +
                '}';
    }
}
