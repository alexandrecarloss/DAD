package servidor;

import rmi.ICalculadora;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculadoraImplementacao extends UnicastRemoteObject implements ICalculadora {


    protected CalculadoraImplementacao() throws RemoteException {
        super();
    }

    @Override
    public double somar(double valor1, double valor2) throws RemoteException {
        System.out.println("Chamada somar: " + valor1 + " " + valor2);
        return valor1 + valor2;
    }

    @Override
    public double subtrair(double valor1, double valor2) throws RemoteException {
        System.out.println("Chamada subtrair: " + valor1 + " " + valor2);
        return valor1 - valor2;
    }

    @Override
    public double multiplicar(double valor1, double valor2) throws RemoteException {
        System.out.println("Chamada multilicar: " + valor1 + " " + valor2);
        return valor1 * valor2;
    }

    @Override
    public double dividir(double valor1, double valor2) throws RemoteException {
        System.out.println("Chamada dividir: " + valor1 + " " + valor2);
        if (valor1 == 0) {
            return 0;
        } else {
            return valor1 / valor2;
        }

    }
}
