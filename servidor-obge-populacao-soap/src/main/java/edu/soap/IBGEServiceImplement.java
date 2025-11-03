package edu.soap;

import javax.jws.WebService;

@WebService(
        endpointInterface = "edu.soap.IBGEService"
)
public class IBGEServiceImplement implements IBGEService {

    @Override
    public String teste() {
        return "FOI!";
    }
}
