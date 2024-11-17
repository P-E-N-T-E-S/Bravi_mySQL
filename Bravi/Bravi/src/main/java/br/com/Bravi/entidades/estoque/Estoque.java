package br.com.Bravi.entidades.estoque;

public class Estoque {

    private int setor;
    private int qtd;
    private int produtoNsm;

    // Ex
    private String produtoNome;
    private String setorNome;


    public Estoque(int setor, int qtd, int produtoNsm) {
        this.setor = setor;
        this.qtd = qtd;
        this.produtoNsm = produtoNsm;
    }

    public Estoque() {}

    public int getSetor() {
        return setor;
    }

    public void setSetor(int setor) {
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

    @Override
    public String toString() {
        return "Estoque{" +
                "setor=" + setor +
                ", qtd=" + qtd +
                ", produtoNsm=" + produtoNsm +
                '}';
    }
}
