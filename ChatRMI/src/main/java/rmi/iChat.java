package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface iChat extends Remote {
    void enviarMensagem(String mensagem, String usuario) throws RemoteException; // Adiciona uma mensagem ao servidor
    List<String> receberMensagens(String usuario) throws RemoteException; // Retorna a lista de mensagens
    boolean autenticar(String usuario, String senha) throws RemoteException;
}
