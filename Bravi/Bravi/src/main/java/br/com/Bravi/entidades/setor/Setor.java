package br.com.Bravi.entidades.setor;

public class Setor {
    private int id;
    private String nome;

    public Setor() {
    }

    public Setor(int id) {
        this.id = id;
    }

    public Setor(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
