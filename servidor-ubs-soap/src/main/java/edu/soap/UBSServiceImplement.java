package edu.soap;

import dao.UBSResumoDAO;
import model.UBSResumo;

import javax.jws.WebService;

@WebService(endpointInterface = "edu.soap.UBSService")
public class UBSServiceImplement implements UBSService {

    @Override
    public String testeUBS() {
        return "Conexão com o serviço UBS estabelecida!";
    }

    @Override
    public UBSResumo resumoUBS(String uf, String municipio) {
        UBSResumoDAO dao = new UBSResumoDAO();
        return dao.getResumoPorEstadoMunicipio(uf, municipio);
    }
}
