package edu.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IBGEService {
    @WebMethod
    String teste();

}
