package rmi;

import model.Cidade;

import java.rmi.Remote;
import java.util.List;

public interface ICidadeManager extends Remote {
    public List<Cidade> getCidades();
}
