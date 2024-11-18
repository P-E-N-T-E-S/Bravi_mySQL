package br.com.Bravi.entidades.produto;

import br.com.Bravi.entidades.categoria.Categoria;

public class Produto {

    private int nsm;
    private String nome;
    private String descricao;
    private Categoria categoria;

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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
