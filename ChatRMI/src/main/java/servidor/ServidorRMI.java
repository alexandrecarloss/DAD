package servidor;

import rmi.iChat;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServidorRMI {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        iChat chat = new ChatImp();

        Registry registro = LocateRegistry.createRegistry(2000);

        registro.rebind("rmi://localhost:2000/chat", chat);
        System.out.println("Servidor RMI iniciado!");
    }
}
