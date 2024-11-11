package br.com.Bravi.entidades.fornece;

import java.util.Date;

public class Fornece {

    private int id;
    private int produtoNsm;
    private String fornecedorCnpj;
    private Date data;
    private double valor;

    public Fornece(int id, int produtoNsm, String fornecedorCnpj, Date data, double valor) {
        this.id = id;
        this.produtoNsm = produtoNsm;
        this.fornecedorCnpj = fornecedorCnpj;
        this.data = data;
        this.valor = valor;
    }

    public Fornece(int produtoNsm, String fornecedorCnpj, Date data, double valor) {
        this.produtoNsm = produtoNsm;
        this.fornecedorCnpj = fornecedorCnpj;
        this.data = data;
        this.valor = valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Fornece{" +
                "id=" + id +
                ", produtoNsm=" + produtoNsm +
                ", fornecedorCnpj='" + fornecedorCnpj + '\'' +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
