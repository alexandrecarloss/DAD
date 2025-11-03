package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Estado {

    private int id;
    private String codigo_ibge;
    private String nome;
    private String sigla;

    public Estado() {}

    public Estado(int id, String codigo_ibge, String nome, String sigla) {
        this.id = id;
        this.codigo_ibge = codigo_ibge;
        this.nome = nome;
        this.sigla = sigla;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCodigo_ibge() { return codigo_ibge; }
    public void setCodigo_ibge(String codigo_ibge) { this.codigo_ibge = codigo_ibge; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getSigla() { return sigla; }
    public void setSigla(String sigla) { this.sigla = sigla; }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", codigo_ibge='" + codigo_ibge + '\'' +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}