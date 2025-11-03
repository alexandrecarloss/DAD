package entity;

import javax.persistence.*;

@Entity
public class CidadePacote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = false, nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String codigo;

    public CidadePacote() {}

    public CidadePacote(String nome, String codigo) {
        this.nome = nome;
        this.codigo = codigo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    @Override
    public String toString() {
        return "Cidade{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }
}
