package servidor;

import rmi.CidadeManager;
import rmi.ICidadeManager;

public class ServidorRMI {
    public static void main(String[] args) {
        ICidadeManager cidadeManager = new CidadeManager();
        
        cidadeManager.getCidades();

        System.out.println(cidadeManager.getCidades());
    }
}
