import model.Cidade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICidadeManager extends Remote {
    public List<Cidade> getCidades() throws RemoteException;
}
