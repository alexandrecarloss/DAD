package edu.soap; // Use o pacote que você definiu para os serviços

import model.UBSResumo;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface UBSService {

    @WebMethod
    String testeUBS();

    @WebMethod
    UBSResumo resumoUBS(String uf, String municipio);

}