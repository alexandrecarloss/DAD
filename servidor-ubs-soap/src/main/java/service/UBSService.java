package service;

import dao.UBSResumoDAO;
import model.UBSResumo;

public class UBSService {

    private UBSResumoDAO dao;

    public UBSService() {
        this.dao = new UBSResumoDAO(); // inicializa o DAO
    }

    /**
     * Retorna o resumo de UBS para um estado e opcionalmente um município
     */
    public UBSResumo getResumo(String uf, String municipio) {
        // aqui você pode adicionar regras de negócio, validações etc.
        if (uf == null || uf.isEmpty()) {
            throw new IllegalArgumentException("O estado (UF) é obrigatório");
        }

        // chama o DAO para obter os dados
        UBSResumo resumo = dao.getResumoPorEstadoMunicipio(uf, municipio);

        // você pode fazer algum pós-processamento se precisar
        // por exemplo, ordenar a lista de UBS por nome
        resumo.getLocalizacoes().sort((a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));

        return resumo;
    }
}
