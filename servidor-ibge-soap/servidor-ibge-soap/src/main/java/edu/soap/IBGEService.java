package edu.soap;

import model.Estado;
import model.Municipio;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IBGEService {
    @WebMethod
    String teste();

    @WebMethod
    String getEstado(String nome);

    @WebMethod
    String estados();

    @WebMethod
    String getMunicipio(String estado, String nome);
}