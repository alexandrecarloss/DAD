import edu.soap.IBGEServiceImplement;

import javax.xml.ws.Endpoint;

public class ServidorSOAP {
    public static void main(String[] args) {
        IBGEServiceImplement Impl = new IBGEServiceImplement();
        String url = "http://localhost:8080/ibge";
        Endpoint.publish(url, Impl);
        System.out.println("Servidor iniciado! url:"+url);

    }
}
