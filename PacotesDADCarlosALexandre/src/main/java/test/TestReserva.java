package test;

import DAO.GenericDAO;
import entity.CidadePacote;
import entity.ReservaPacote;
import javax.persistence.EntityManager;
import util.ConexaoUtil;

public class TestReserva {
    public TestReserva() {
    }

    private static void inserirReserva() {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        CidadePacote cidadePacote = (CidadePacote)entityManager.find(CidadePacote.class, 1L);
        if (cidadePacote == null) {
            System.out.println("Cidade com ID 1 não encontrada!");
            entityManager.close();
        } else {
            GenericDAO<ReservaPacote> genericDAO = new GenericDAO(ReservaPacote.class, entityManager);
            ReservaPacote reservaPacote = new ReservaPacote(cidadePacote, 500.0);
            genericDAO.inserir(reservaPacote);
            System.out.println("Reserva inserida com sucesso!");
            entityManager.close();
        }
    }

    public static void main(String[] args) {
        inserirReserva();
    }
}
