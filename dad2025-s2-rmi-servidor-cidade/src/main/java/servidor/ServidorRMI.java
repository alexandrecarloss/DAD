package servidor;

import rmi.CidadeManager;
import rmi.ICidadeManager;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) throws RemoteException {
        ICidadeManager cidadeManager = new CidadeManager();

        Registry registro = LocateRegistry.createRegistry(2001);

        registro.rebind("rmi://localhost:2001/cidade", cidadeManager);
        System.out.println("Servidor RMI iniciado!");
    }
}
