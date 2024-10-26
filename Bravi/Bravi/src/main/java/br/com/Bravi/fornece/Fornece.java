package br.com.Bravi.fornece;

import java.util.Date;

public class Fornece {

    private int id;
    private int produtoNsm;
    private String fornecedorCnpj;
    private Date data;

    public Fornece(int id, int produtoNsm, String fornecedorCnpj, Date data) {
        this.id = id;
        this.produtoNsm = produtoNsm;
        this.fornecedorCnpj = fornecedorCnpj;
        this.data = data;
    }

    public Fornece(int produtoNsm, String fornecedorCnpj, Date data) {
        this.produtoNsm = produtoNsm;
        this.fornecedorCnpj = fornecedorCnpj;
        this.data = data;
    }

    public Fornece() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoNsm() {
        return produtoNsm;
    }

    public void setProdutoNsm(int produtoNsm) {
        this.produtoNsm = produtoNsm;
    }

    public String getFornecedorCnpj() {
        return fornecedorCnpj;
    }

    public void setFornecedorCnpj(String fornecedorCnpj) {
        this.fornecedorCnpj = fornecedorCnpj;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Fornece{" +
                "id=" + id +
                ", produtoNsm=" + produtoNsm +
                ", fornecedorCnpj='" + fornecedorCnpj + '\'' +
                ", data=" + data +
                '}';
    }
}
