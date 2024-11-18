package br.com.Bravi.entidades.produto;

import br.com.Bravi.entidades.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Produto {

    @JsonProperty("nsm")
    private int nsm;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("categoria")
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
