package br.com.Bravi.entidades.categoria_produto;

public class CategoriaProduto {
    private int nsm;
    private int idCategoria;

    public CategoriaProduto(int nsm, int idCategoria) {
        this.nsm = nsm;
        this.idCategoria = idCategoria;
    }

    public int getNsm() {
        return nsm;
    }

    public void setNsm(int nsm) {
        this.nsm = nsm;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
}
