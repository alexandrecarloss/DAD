package entity;

import javax.persistence.*;

@Entity
@Table(name = "ubs_localizacao")
public class UBSLocalizacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "LOGRADOURO")
    private String logradouro;

    @Column(name = "BAIRRO")
    private String bairro;

    @Column(name = "LATITUDE")
    private Double latitude;

    @Column(name = "LONGITUDE")
    private Double longitude;

    @Column(name = "UF")
    private String uf;

    @Column(name = "IBGE")
    private String ibge;

    public UBSLocalizacao() {
    }

    public UBSLocalizacao(String nome, String logradouro, String bairro, double latitude, double longitude) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UBSLocalizacao{" +
                "nome='" + nome + '\'' +
                ", logradouro='" + logradouro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
