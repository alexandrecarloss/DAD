package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Municipio {
    private int cd_mun;
    private String estado;
    private String nm_mun;
    private int total_moradores;
    private int sexo_masculino;
    private int sexo_feminino;
    private int sexo_idade0a9;
    private int sexo_idade10a19;
    private int sexo_idade20a39;
    private int sexo_idade40mais;

    public Municipio() {}

    public Municipio(int cd_mun, String estado, String nm_mun, int total_moradores, int sexo_masculino, int sexo_feminino, int sexo_idade0a9, int sexo_idade10a19, int sexo_idade20a39, int sexo_idade40mais) {
        this.cd_mun = cd_mun;
        this.estado = estado;
        this.nm_mun = nm_mun;
        this.total_moradores = total_moradores;
        this.sexo_masculino = sexo_masculino;
        this.sexo_feminino = sexo_feminino;
        this.sexo_idade0a9 = sexo_idade0a9;
        this.sexo_idade10a19 = sexo_idade10a19;
        this.sexo_idade20a39 = sexo_idade20a39;
        this.sexo_idade40mais = sexo_idade40mais;
    }

    // --- Getters e Setters ---
    public int getCd_mun() {
        return cd_mun;
    }

    public void setCd_mun(int cd_mun) {
        this.cd_mun = cd_mun;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNm_mun() {
        return nm_mun;
    }

    public void setNm_mun(String nm_mun) {
        this.nm_mun = nm_mun;
    }

    public int getTotal_moradores() {
        return total_moradores;
    }

    public void setTotal_moradores(int total_moradores) {
        this.total_moradores = total_moradores;
    }

    public int getSexo_masculino() {
        return sexo_masculino;
    }

    public void setSexo_masculino(int sexo_masculino) {
        this.sexo_masculino = sexo_masculino;
    }

    public int getSexo_feminino() {
        return sexo_feminino;
    }

    public void setSexo_feminino(int sexo_feminino) {
        this.sexo_feminino = sexo_feminino;
    }

    public int getSexo_idade0a9() {
        return sexo_idade0a9;
    }

    public void setSexo_idade0a9(int sexo_idade0a9) {
        this.sexo_idade0a9 = sexo_idade0a9;
    }

    public int getSexo_idade10a19() {
        return sexo_idade10a19;
    }

    public void setSexo_idade10a19(int sexo_idade10a19) {
        this.sexo_idade10a19 = sexo_idade10a19;
    }

    public int getSexo_idade20a39() {
        return sexo_idade20a39;
    }

    public void setSexo_idade20a39(int sexo_idade20a39) {
        this.sexo_idade20a39 = sexo_idade20a39;
    }

    public int getSexo_idade40mais() {
        return sexo_idade40mais;
    }

    public void setSexo_idade40mais(int sexo_idade40mais) {
        this.sexo_idade40mais = sexo_idade40mais;
    }

    @Override
    public String toString() {
        return "Municipio{" +
                "CD_MUN=" + cd_mun +
                ", ESTADO='" + estado + '\'' +
                ", NM_MUN='" + nm_mun + '\'' +
                ", Total Moradores=" + total_moradores +
                ", Sexo Masculino=" + sexo_masculino +
                ", Sexo Feminino=" + sexo_feminino +
                ", Idade 0-9=" + sexo_idade0a9 +
                ", Idade 10-19=" + sexo_idade10a19 +
                ", Idade 20-39=" + sexo_idade20a39 +
                ", Idade 40+="+ sexo_idade40mais +
                '}';
    }
}