package rmi;

import model.Cidade;
import model.Estado;

import java.util.ArrayList;
import java.util.List;

public class CidadeManager implements ICidadeManager {

    private List<Cidade> cidades = new ArrayList<>();

    public CidadeManager() {
        carregarCidade();
    }

    public void carregarCidade() {
        Estado estado1 = new Estado("Amazonas", "AM");
        Estado estado2 = new Estado("Roraima", "AM");

        cidades.add(new Cidade("Manaus", estado1));
        cidades.add(new Cidade("Iranduba", estado1));
        cidades.add(new Cidade("Itacoatiara", estado1));
        cidades.add(new Cidade("Boa Vista", estado2));
        cidades.add(new Cidade("Pacaraima", estado2));
    }

    @Override
    public List<Cidade> getCidades() {
        return this.cidades;
    }
}
