

package test;

import entity.Pacote;
import entity.ReservaPacote;
import javax.persistence.EntityManager;
import util.ConexaoUtil;

public class TestPegandoReserva {
    public TestPegandoReserva() {
    }

    public static void getReserva() {
        EntityManager entityManager = ConexaoUtil.getEntityManager();
        ReservaPacote reservaPacote = (ReservaPacote)entityManager.find(ReservaPacote.class, 1L);
        if (reservaPacote == null) {
            System.out.println("Reserva com ID 1 não encontrada!");
            entityManager.close();
        } else {
            Pacote pacote = new Pacote();
            pacote.setReserva(reservaPacote);
            System.out.println(pacote.somaValores());
        }
    }

    public static void main(String[] args) {
        getReserva();
    }
}
