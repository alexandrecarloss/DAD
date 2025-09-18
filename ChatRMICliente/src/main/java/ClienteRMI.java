import rmi.iChat;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registro = LocateRegistry.getRegistry(2000);

        //Ver a lista do catalodo
        String[] listaCatalogo = registro.list();

        // Obter objeto do catálogo
        iChat chat = (iChat) registro.lookup("rmi://localhost:2000/chat");

        // Autenticando
        chat.autenticar("carlos", "admin");

        // Enviando mensagens por usuário autenticado
        chat.enviarMensagem("Olá, chat", "carlos");

        //Recebendo mensagens
        System.out.println("Todas as mensagens: ");
        System.out.println(chat.receberMensagens("carlos"));

        // Enviando mensagens por usuário não válido
        chat.enviarMensagem("Olá, mundo, não me autentiquei", "admin");
        chat.enviarMensagem("Olá, mundo, não sou cadastrado", "joao");
    }
}
