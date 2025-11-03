package edu.soap;

import dao.EstadoDAO;
import dao.MunicipioDAO;
import model.Estado;
import model.Municipio;

import javax.jws.WebService;
import java.util.List;

@WebService(
        endpointInterface = "edu.soap.IBGEService"
)
public class IBGEServiceImplement implements IBGEService {

    private EstadoDAO estadoDAO = new EstadoDAO();
    private MunicipioDAO municipioDAO = new MunicipioDAO();

    @Override
    public String teste() {
        return "Conexão com o serviço IBGE estabelecida!";
    }

    @Override
    public String getEstado(String nome) {
        Estado estado = estadoDAO.getEstadoByNome(nome);
        if (estado != null) {

            return "Informações do Estado:\n" +
                    "ID: " + estado.getId() + "\n" +
                    "Código IBGE: " + estado.getCodigo_ibge() + "\n" +
                    "Nome: " + estado.getNome() + "\n" +
                    "Sigla: " + estado.getSigla();
        } else {
            return "Estado com nome '" + nome + "' não encontrado.";
        }
    }

    @Override
    public String estados() {
        List<Estado> listaEstados = estadoDAO.getAllEstados();
        if (listaEstados.isEmpty()) {
            return "Nenhum estado encontrado.";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Lista de Estados:\n");
            for (Estado estado : listaEstados) {
                sb.append(" - ").append(estado.getNome()).append(" (").append(estado.getSigla()).append(")\n");
            }
            return sb.toString();
        }
    }

    @Override
    public String getMunicipio(String estadoNome, String municipioNome) {
        Municipio municipio = municipioDAO.getMunicipioByNomeAndEstado(municipioNome, estadoNome);
        if (municipio != null) {
            return "Informações do Município:\n" +
                    "Código IBGE Município: " + municipio.getCd_mun() + "\n" +
                    "Estado: " + municipio.getEstado() + "\n" +
                    "Nome: " + municipio.getNm_mun() + "\n" +
                    "Total de Moradores: " + municipio.getTotal_moradores() + "\n" +
                    "Sexo Masculino: " + municipio.getSexo_masculino() + "\n" +
                    "Sexo Feminino: " + municipio.getSexo_feminino() + "\n" +
                    "Idade 0-9 anos: " + municipio.getSexo_idade0a9() + "\n" +
                    "Idade 10-19 anos: " + municipio.getSexo_idade10a19() + "\n" +
                    "Idade 20-39 anos: " + municipio.getSexo_idade20a39() + "\n" +
                    "Idade 40+ anos: " + municipio.getSexo_idade40mais();
        } else {
            return "Município '" + municipioNome + "' no estado '" + estadoNome + "' não encontrado.";
        }
    }
}