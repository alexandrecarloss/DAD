import DAO.GenericDAO;
import entity.CidadePacote;
import entity.HotelPacote;
import util.ConexaoUtil;

import javax.persistence.EntityManager;

public class GenericDAOExec {

    private static void inserirCidade(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericDAO<CidadePacote> genericDAO = new GenericDAO(CidadePacote.class, entityManager);

        CidadePacote cidadePacote = new CidadePacote("São Paulo","3550308");

        genericDAO.inserir(cidadePacote);

        entityManager.close();

    }

    private static void inserirHotel(){

        EntityManager entityManager = ConexaoUtil.getEntityManager();

        GenericDAO<CidadePacote> cidadeDAO = new GenericDAO(CidadePacote.class, entityManager);

        GenericDAO<HotelPacote> hotelDAO = new GenericDAO(HotelPacote.class, entityManager);


        CidadePacote cidadePacote = entityManager.find(CidadePacote.class, 2L);

        HotelPacote hotelPacote =  new HotelPacote(cidadePacote,1526.56);

        hotelDAO.inserir(hotelPacote);

        entityManager.close();

    }

    public static void main(String[] args) {

        //inserirCidade();

        inserirHotel();

    }
}
