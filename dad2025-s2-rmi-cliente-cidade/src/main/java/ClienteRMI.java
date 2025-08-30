import model.Cidade;
import rmi.CidadeManager;
import rmi.ICidadeManager;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class ClienteRMI {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registro = LocateRegistry.getRegistry(2001);

        //Ver a lista do catalodo
        String[] listaCatalogo = registro.list();

        for (String item: listaCatalogo) {
            System.out.println(item);
        }

        // Obter objeto do catálogo
        ICidadeManager cidadeManager = (ICidadeManager) registro.lookup("rmi://localhost:2001/cidade");

        List<Cidade> resultado = cidadeManager.getCidades();
        System.out.println(resultado);


    }
}
