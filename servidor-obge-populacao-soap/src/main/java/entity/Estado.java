package entity;

import javax.persistence.*;

@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String uf;

    @Column(nullable = false)
    private int populacaoTotal;

    @Column(nullable = false)
    private int populacaoHomens;

    @Column(nullable = false)
    private int populacaoMulheres;

    @Column(nullable = false)
    private int faixa0a10;

    @Column(nullable = false)
    private int faixa11a20;

    @Column(nullable = false)
    private int faixa21a30;

    @Column(nullable = false)
    private int faixa31a40;

    @Column(nullable = false)
    private int faixa40Mais;

    // Construtores
    public Estado() {}

    public Estado(String nome, String uf, int populacaoTotal, int populacaoHomens,
                  int populacaoMulheres, int faixa0a10, int faixa11a20,
                  int faixa21a30, int faixa31a40, int faixa40Mais) {
        this.nome = nome;
        this.uf = uf;
        this.populacaoTotal = populacaoTotal;
        this.populacaoHomens = populacaoHomens;
        this.populacaoMulheres = populacaoMulheres;
        this.faixa0a10 = faixa0a10;
        this.faixa11a20 = faixa11a20;
        this.faixa21a30 = faixa21a30;
        this.faixa31a40 = faixa31a40;
        this.faixa40Mais = faixa40Mais;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getUf() { return uf; }
    public void setUf(String uf) { this.uf = uf; }
    public int getPopulacaoTotal() { return populacaoTotal; }
    public void setPopulacaoTotal(int populacaoTotal) { this.populacaoTotal = populacaoTotal; }
    public int getPopulacaoHomens() { return populacaoHomens; }
    public void setPopulacaoHomens(int populacaoHomens) { this.populacaoHomens = populacaoHomens; }
    public int getPopulacaoMulheres() { return populacaoMulheres; }
    public void setPopulacaoMulheres(int populacaoMulheres) { this.populacaoMulheres = populacaoMulheres; }
    public int getFaixa0a10() { return faixa0a10; }
    public void setFaixa0a10(int faixa0a10) { this.faixa0a10 = faixa0a10; }
    public int getFaixa11a20() { return faixa11a20; }
    public void setFaixa11a20(int faixa11a20) { this.faixa11a20 = faixa11a20; }
    public int getFaixa21a30() { return faixa21a30; }
    public void setFaixa21a30(int faixa21a30) { this.faixa21a30 = faixa21a30; }
    public int getFaixa31a40() { return faixa31a40; }
    public void setFaixa31a40(int faixa31a40) { this.faixa31a40 = faixa31a40; }
    public int getFaixa40Mais() { return faixa40Mais; }
    public void setFaixa40Mais(int faixa40Mais) { this.faixa40Mais = faixa40Mais; }

    @Override
    public String toString() {
        return nome + " (" + uf + ")";
    }
}