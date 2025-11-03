package edu.soap;// package edu.soap; ou no pacote principal como o seu ServidorSOAP

import edu.soap.UBSServiceImplement;
import javax.xml.ws.Endpoint;

public class ServidorSOAPUBS {
    public static void main(String[] args) {
        UBSServiceImplement Impl = new UBSServiceImplement();
        // Escolha uma porta ou URL diferente, ou mude o path
        String url = "http://localhost:8080/ubs";
        Endpoint.publish(url, Impl);
        System.out.println("Servidor UBS iniciado! url:"+url + "?wsdl");
    }
}