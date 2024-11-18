package br.com.Bravi.entidades.estoque;

import br.com.Bravi.entidades.setor.Setor;
import br.com.Bravi.entidades.categoria.Categoria;

public class Estoque {

    private Setor setor;
    private Integer idSetor;
    private int qtd;
    private int produtoNsm;

    public Estoque(Setor setor, Integer idSetor, int qtd, int produtoNsm) {
        this.setor = setor;
        this.idSetor = idSetor;
        this.qtd = qtd;
        this.produtoNsm = produtoNsm;
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

    public Integer getIdSetor() {
        return idSetor;
    }

    public void setIdSetor(Integer idSetor) {
        this.idSetor = idSetor;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "setor=" + setor +
                ", qtd=" + qtd +
                ", produtoNsm=" + produtoNsm +
                '}';
    }
}
