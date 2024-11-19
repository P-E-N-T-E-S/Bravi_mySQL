package br.com.Bravi.entidades.produto;

import br.com.Bravi.entidades.categoria.Categoria;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Produto {

    @JsonProperty("nsm")
    private int nsm;
    @JsonProperty("nome")
    private String nome;
    @JsonProperty("descricao")
    private String descricao;
    @JsonProperty("categorias_id")
    private List<Integer> categoriasId;
    @JsonProperty("categorias")
    private List<Categoria> categoria;


    public Produto(int nsm, String nome, String descricao, List<Integer> categoriasId) {
        this.nsm = nsm;
        this.nome = nome;
        this.descricao = descricao;
        this.categoriasId = categoriasId;
    }

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

    public List<Integer> getCategoriasId() {
        return categoriasId;
    }

    public void setCategoriasId(List<Integer> categorias_id) {
        this.categoriasId = categorias_id;
    }

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categoria) {
        this.categoria = categoria;
    }
}
