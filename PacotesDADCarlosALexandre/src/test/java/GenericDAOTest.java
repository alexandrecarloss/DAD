import DAO.GenericDAO;
import entity.CidadePacote;
import org.junit.jupiter.api.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class GenericDAOTest {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private GenericDAO<CidadePacote> cidadeDao;

    @BeforeAll
    public static void setupClass() {

        emf = Persistence.createEntityManagerFactory("BancoTestPU");

    }

    @BeforeEach
    public void setup() {

        em = emf.createEntityManager();
        cidadeDao = new GenericDAO<>(CidadePacote.class, em);

    }

    @AfterEach
    public void tearDown() {
        if (em != null) {
            // Inicia uma transação para limpar a tabela
            em.getTransaction().begin();
            // Executa um comando para deletar todos os registros de CidadePacote
            em.createQuery("DELETE FROM CidadePacote").executeUpdate();
            em.getTransaction().commit();

            // Fecha o EntityManager
            em.close();
        }
    }

    @AfterAll
    public static void teardownClass() {
        if(emf != null){
            emf.close();
        }
    }

    @Test
    @DisplayName("Deve salvar uma nova CidadePacote no banco de dados")
    public void deveSalvarCidadePacote() {

        CidadePacote cidadePacote = new CidadePacote("Manaus", "MAO");

        cidadeDao.inserir(cidadePacote);

        CidadePacote cidadeSalva = em.createQuery("SELECT c FROM CidadePacote c WHERE c.codigo = :codigo",CidadePacote.class)
                .setParameter("codigo","MAO")
                .getSingleResult();
        assertNotNull(cidadeSalva, "A cidade não deveria ser nula após ser salva.");
        assertEquals("Manaus", cidadeSalva.getNome(), "O nome da cidade salva está incorreto.");
        assertEquals("MAO", cidadeSalva.getCodigo(), "O código da cidade salva está incorreto.");
    }

    @Test
    @DisplayName("Deve consultar uma CidadePacote pelo seu ID")
    public void deveConsultarCidadePacotePorId() {
        // Cenário
        CidadePacote cidadeParaSalvar = new CidadePacote("Rio de Janeiro", "GIG");

        // Ação - Inserimos primeiro para depois consultar
        cidadeDao.inserir(cidadeParaSalvar);

        // Limpa o cache de persistência para garantir que a consulta vá ao banco
        em.clear();

        // Buscando a cidade que foi inserida para obter o ID gerado
        CidadePacote cidadeInserida = em.createQuery("SELECT c FROM CidadePacote c WHERE c.codigo = :codigo", CidadePacote.class)
                .setParameter("codigo", "GIG")
                .getSingleResult();

        Long idInserido = cidadeInserida.getId();// Supondo que você adicionou o getter para o ID na entidade

        System.out.println(cidadeParaSalvar.getId());
        // Verificação
        CidadePacote cidadeConsultada = cidadeDao.consultar(idInserido);

        assertNotNull(cidadeConsultada);
        assertEquals("Rio de Janeiro", cidadeConsultada.getNome());
    }
}
