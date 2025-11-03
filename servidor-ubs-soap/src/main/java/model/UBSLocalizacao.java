package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UBSLocalizacao {
    private String nome;
    private String logradouro;
    private String bairro;
    private double latitude;
    private double longitude;

    public UBSLocalizacao() {}

    public UBSLocalizacao(String nome, String logradouro, String bairro, double latitude, double longitude) {
        this.nome = nome;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters e setters

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getLogradouro() { return logradouro; }
    public void setLogradouro(String logradouro) { this.logradouro = logradouro; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
    public void setLongitude(double longitude) { this.longitude = longitude; }
}
