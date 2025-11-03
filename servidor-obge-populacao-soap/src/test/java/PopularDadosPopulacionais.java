package test;

import DAO.GenericDAO;
import entity.Cidade;
import entity.Estado;
import util.ConexaoUtil;

import javax.persistence.EntityManager;

public class PopularDadosPopulacionais {

    public static void main(String[] args) {
        EntityManager entityManager = ConexaoUtil.getEntityManager();

        // Criar alguns estados exemplo
        Estado sp = new Estado("São Paulo", "SP", 44000000, 21500000, 22500000,
                6000000, 7000000, 8000000, 7000000, 16000000);

        Estado mg = new Estado("Minas Gerais", "MG", 21000000, 10300000, 10700000,
                3000000, 3500000, 4000000, 3500000, 7000000);

        Estado rj = new Estado("Rio de Janeiro", "RJ", 17000000, 8200000, 8800000,
                2400000, 2800000, 3200000, 2800000, 5800000);

        GenericDAO<Estado> estadoDAO = new GenericDAO<>(Estado.class, entityManager);
        estadoDAO.inserir(sp);
        estadoDAO.inserir(mg);
        estadoDAO.inserir(rj);

        // Criar algumas cidades exemplo
        GenericDAO<Cidade> cidadeDAO = new GenericDAO<>(Cidade.class, entityManager);

        Cidade saoPaulo = new Cidade("São Paulo", sp, 12000000, 5800000, 6200000,
                1700000, 1900000, 2200000, 1900000, 4300000);

        Cidade campinas = new Cidade("Campinas", sp, 1200000, 580000, 620000,
                170000, 190000, 220000, 190000, 430000);

        Cidade bh = new Cidade("Belo Horizonte", mg, 2500000, 1200000, 1300000,
                350000, 400000, 450000, 400000, 900000);

        Cidade rio = new Cidade("Rio de Janeiro", rj, 6700000, 3200000, 3500000,
                950000, 1100000, 1250000, 1100000, 2400000);

        cidadeDAO.inserir(saoPaulo);
        cidadeDAO.inserir(campinas);
        cidadeDAO.inserir(bh);
        cidadeDAO.inserir(rio);

        entityManager.close();
        ConexaoUtil.fecharFabrica();

        System.out.println("Dados populacionais inseridos com sucesso!");
    }
}