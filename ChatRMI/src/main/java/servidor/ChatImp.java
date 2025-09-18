package servidor;

import rmi.iChat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ChatImp extends UnicastRemoteObject implements iChat {
    List<String> mensagens = new ArrayList<>();
    private final Map<String, String> usuariosValidos;
    private final Map<String, Boolean> usuariosAutenticados = new HashMap<>();

    protected ChatImp() throws RemoteException {
        super();
        usuariosValidos = new HashMap<>();
        usuariosValidos.put("admin", "admin123");
        usuariosValidos.put("carlos", "admin");
        usuariosValidos.put("user2", "senha2");
        usuariosValidos.put("aluno", "java123");
    }

    @Override
    public synchronized  void enviarMensagem(String mensagem, String usuario) throws RemoteException {
        verificarAutenticacao(usuario);
        mensagens.add(mensagem);
        System.out.println("Nova mensagem");
    }

    @Override
    public synchronized  List<String> receberMensagens(String usuario) throws RemoteException {
        verificarAutenticacao(usuario);
        return mensagens;
    }

    @Override
    public boolean autenticar(String usuario, String senha) throws RemoteException {
        if (usuariosValidos.containsKey(usuario) && usuariosValidos.get(usuario).equals(senha)) {
            System.out.println("Usuário autenticado: " + usuario);
            usuariosAutenticados.put(usuario, true);
            return true;
        }
        System.out.println("Tentativa de autenticação falhou para: " + usuario);
        return false;
    }

    private void verificarAutenticacao(String usuario) throws RemoteException {
        if (!usuariosAutenticados.containsKey(usuario) || !usuariosAutenticados.get(usuario)) {
            throw new RemoteException("Usuário não autenticado: " + usuario);
        }
    }
}
