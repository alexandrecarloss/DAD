package entity;

import java.util.List;

public class UBSResumo {
    private String uf;
    private String municipio;
    private int totalUBS;
    private int totalMedicos;
    private int totalEnfermeiros;
    private List<UBSLocalizacao> localizacoes;

    public UBSResumo() {
    }

    public UBSResumo(String uf, String municipio, int totalUBS, int totalMedicos, int totalEnfermeiros, List<UBSLocalizacao> localizacoes) {
        this.uf = uf;
        this.municipio = municipio;
        this.totalUBS = totalUBS;
        this.totalMedicos = totalMedicos;
        this.totalEnfermeiros = totalEnfermeiros;
        this.localizacoes = localizacoes;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getTotalUBS() {
        return totalUBS;
    }

    public void setTotalUBS(int totalUBS) {
        this.totalUBS = totalUBS;
    }

    public int getTotalMedicos() {
        return totalMedicos;
    }

    public void setTotalMedicos(int totalMedicos) {
        this.totalMedicos = totalMedicos;
    }

    public int getTotalEnfermeiros() {
        return totalEnfermeiros;
    }

    public void setTotalEnfermeiros(int totalEnfermeiros) {
        this.totalEnfermeiros = totalEnfermeiros;
    }

    public List<UBSLocalizacao> getLocalizacoes() {
        return localizacoes;
    }

    public void setLocalizacoes(List<UBSLocalizacao> localizacoes) {
        this.localizacoes = localizacoes;
    }

    @Override
    public String toString() {
        return "UBSResumo{" +
                "uf='" + uf + '\'' +
                ", municipio='" + municipio + '\'' +
                ", totalUBS=" + totalUBS +
                ", totalMedicos=" + totalMedicos +
                ", totalEnfermeiros=" + totalEnfermeiros +
                ", localizacoes=" + localizacoes +
                '}';
    }
}
