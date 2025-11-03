package service;

import DAO.GenericDAO;
import entity.Cidade;
import entity.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PopulacaoService {

    private EntityManager entityManager;

    public PopulacaoService() {
        this.entityManager = ConexaoUtil.getEntityManager();
    }

    public List<Estado> listarEstados() {
        GenericDAO<Estado> estadoDAO = new GenericDAO<>(Estado.class, entityManager);
        return estadoDAO.listar();
    }

    public List<Cidade> listarCidadesPorEstado(Long estadoId) {
        String jpql = "SELECT c FROM Cidade c WHERE c.estado.id = :estadoId ORDER BY c.nome";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("estadoId", estadoId);
        return query.getResultList();
    }

    public Estado buscarEstadoPorId(Long id) {
        GenericDAO<Estado> estadoDAO = new GenericDAO<>(Estado.class, entityManager);
        return estadoDAO.consultar(id);
    }

    public Cidade buscarCidadePorId(Long id) {
        GenericDAO<Cidade> cidadeDAO = new GenericDAO<>(Cidade.class, entityManager);
        return cidadeDAO.consultar(id);
    }

    public void exibirDadosPopulacionais(Estado estado) {
        System.out.println("\n=== DADOS POPULACIONAIS - " + estado.getNome().toUpperCase() + " ===");
        System.out.printf("População Total: %,d%n", estado.getPopulacaoTotal());
        System.out.printf("População Masculina: %,d (%.1f%%)%n",
                estado.getPopulacaoHomens(),
                (double) estado.getPopulacaoHomens() / estado.getPopulacaoTotal() * 100);
        System.out.printf("População Feminina: %,d (%.1f%%)%n",
                estado.getPopulacaoMulheres(),
                (double) estado.getPopulacaoMulheres() / estado.getPopulacaoTotal() * 100);

        System.out.println("\n--- DISTRIBUIÇÃO POR FAIXA ETÁRIA ---");
        System.out.printf("0-10 anos: %,d (%.1f%%)%n",
                estado.getFaixa0a10(), (double) estado.getFaixa0a10() / estado.getPopulacaoTotal() * 100);
        System.out.printf("11-20 anos: %,d (%.1f%%)%n",
                estado.getFaixa11a20(), (double) estado.getFaixa11a20() / estado.getPopulacaoTotal() * 100);
        System.out.printf("21-30 anos: %,d (%.1f%%)%n",
                estado.getFaixa21a30(), (double) estado.getFaixa21a30() / estado.getPopulacaoTotal() * 100);
        System.out.printf("31-40 anos: %,d (%.1f%%)%n",
                estado.getFaixa31a40(), (double) estado.getFaixa31a40() / estado.getPopulacaoTotal() * 100);
        System.out.printf("40+ anos: %,d (%.1f%%)%n",
                estado.getFaixa40Mais(), (double) estado.getFaixa40Mais() / estado.getPopulacaoTotal() * 100);
    }

    public void exibirDadosPopulacionais(Cidade cidade) {
        System.out.println("\n=== DADOS POPULACIONAIS - " + cidade.getNome().toUpperCase() + " ===");
        System.out.printf("Estado: %s%n", cidade.getEstado().getNome());
        System.out.printf("População Total: %,d%n", cidade.getPopulacaoTotal());
        System.out.printf("População Masculina: %,d (%.1f%%)%n",
                cidade.getPopulacaoHomens(),
                (double) cidade.getPopulacaoHomens() / cidade.getPopulacaoTotal() * 100);
        System.out.printf("População Feminina: %,d (%.1f%%)%n",
                cidade.getPopulacaoMulheres(),
                (double) cidade.getPopulacaoMulheres() / cidade.getPopulacaoTotal() * 100);

        System.out.println("\n--- DISTRIBUIÇÃO POR FAIXA ETÁRIA ---");
        System.out.printf("0-10 anos: %,d (%.1f%%)%n",
                cidade.getFaixa0a10(), (double) cidade.getFaixa0a10() / cidade.getPopulacaoTotal() * 100);
        System.out.printf("11-20 anos: %,d (%.1f%%)%n",
                cidade.getFaixa11a20(), (double) cidade.getFaixa11a20() / cidade.getPopulacaoTotal() * 100);
        System.out.printf("21-30 anos: %,d (%.1f%%)%n",
                cidade.getFaixa21a30(), (double) cidade.getFaixa21a30() / cidade.getPopulacaoTotal() * 100);
        System.out.printf("31-40 anos: %,d (%.1f%%)%n",
                cidade.getFaixa31a40(), (double) cidade.getFaixa31a40() / cidade.getPopulacaoTotal() * 100);
        System.out.printf("40+ anos: %,d (%.1f%%)%n",
                cidade.getFaixa40Mais(), (double) cidade.getFaixa40Mais() / cidade.getPopulacaoTotal() * 100);
    }

    public void fechar() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}