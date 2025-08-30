import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registro = LocateRegistry.getRegistry(2001);

        //Ver a lista do catalodo
        List<ICidade> listaCatalogo = registro.list();

        for (String item: listaCatalogo) {
            System.out.println(item);
        }

        // Obter objeto do catálogo
        ICalculadora calculadora = (ICalculadora) registro.lookup("rmi://localhost:2001/calculadora");

        double resultado = calculadora.somar(5, 2);
        System.out.println(resultado);

        resultado = calculadora.subtrair(5, 2);
        System.out.println(resultado);

        resultado = calculadora.multiplicar(5, 2);
        System.out.println(resultado);

        resultado = calculadora.dividir(5, 2);
        System.out.println(resultado);
    }
}
