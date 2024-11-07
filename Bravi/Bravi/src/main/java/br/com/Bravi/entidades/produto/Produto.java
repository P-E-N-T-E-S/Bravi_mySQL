package br.com.Bravi.entidades.produto;

public class Produto {

    private int nsm;
    private String nome;
    private String descricao;
    private int fkCategoriaId;

    public Produto(int nsm, String nome, String descricao, int fkCategoriaId) {
        this.nsm = nsm;
        this.nome = nome;
        this.descricao = descricao;
        this.fkCategoriaId = fkCategoriaId;
    }

    public Produto(String nome, String descricao, int fkCategoriaId) {
        this.nome = nome;
        this.descricao = descricao;
        this.fkCategoriaId = fkCategoriaId;
    }

    public Produto() {}

    public int getNsm() {
        return nsm;
    }

    public void setNsm(int nsm) {
        this.nsm = nsm;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFkCategoriaId() {
        return fkCategoriaId;
    }

    public void setFkCategoriaId(int fkCategoriaId) {
        this.fkCategoriaId = fkCategoriaId;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nsm=" + nsm +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", fkCategoriaId=" + fkCategoriaId +
                '}';
    }
}
