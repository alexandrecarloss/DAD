package servidor;

import rmi.ICalculadora;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class ServidorRMI {
    public static void main(String[] args) throws RemoteException, AlreadyBoundException {
        ICalculadora calculadora = new CalculadoraImplementacao();

        Registry registro = LocateRegistry.createRegistry(2000);

        registro.rebind("rmi://localhost:2000/calculadora", calculadora);
        System.out.println("Servidor RMI iniciado!");
    }
}
