package br.com.Bravi.entidades.estoque;

import br.com.Bravi.entidades.setor.Setor;
import br.com.Bravi.entidades.categoria.Categoria;

public class Estoque {

    private Setor setor;
    private int qtd;
    private int produtoNsm;

    // Ex
    private Categoria categoria;

    private String produtoNome;
    private String setorNome;
    private String categoriaNome;

    public Estoque(Setor setor, int qtd, int produtoNsm, Categoria categoria) {
        this.setor = setor;
        this.qtd = qtd;
        this.produtoNsm = produtoNsm;
        this.categoria = categoria;
    }

    public Estoque() {}

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getProdutoNsm() {
        return produtoNsm;
    }

    public void setProdutoNsm(int produtoNsm) {
        this.produtoNsm = produtoNsm;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getProdutoNome() {
        return produtoNome;
    }

    public void setProdutoNome(String produtoNome) {
        this.produtoNome = produtoNome;
    }

    public String getSetorNome() {
        return setorNome;
    }

    public void setSetorNome(String setorNome) {
        this.setorNome = setorNome;
    }

    public String getCategoriaNome() {
        return categoriaNome;
    }

    public void setCategoriaNome(String categoriaNome) {
        this.categoriaNome = categoriaNome;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "setor=" + setor +
                ", qtd=" + qtd +
                ", produtoNsm=" + produtoNsm +
                ", categoria=" + categoria +
                '}';
    }
}
