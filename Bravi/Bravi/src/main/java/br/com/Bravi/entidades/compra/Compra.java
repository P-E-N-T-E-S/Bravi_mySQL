package br.com.Bravi.entidades.compra;

import java.util.Date;

public class Compra {

    private int id;
    private String clienteCnpj;
    private int produtoNsm;
    private Date data;
    private double valor;

    public Compra(int id, String clienteCnpj, int produtoNsm, Date data, double valor) {
        this.id = id;
        this.clienteCnpj = clienteCnpj;
        this.produtoNsm = produtoNsm;
        this.data = data;
        this.valor = valor;
    }

    public Compra(String clienteCnpj, int produtoNsm, Date data, double valor) {
        this.clienteCnpj = clienteCnpj;
        this.produtoNsm = produtoNsm;
        this.data = data;
        this.valor = valor;
    }

    public Compra() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClienteCnpj() {
        return clienteCnpj;
    }

    public void setClienteCnpj(String clienteCnpj) {
        this.clienteCnpj = clienteCnpj;
    }

    public int getProdutoNsm() {
        return produtoNsm;
    }

    public void setProdutoNsm(int produtoNsm) {
        this.produtoNsm = produtoNsm;
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
        return "Compra{" +
                "id=" + id +
                ", clienteCnpj='" + clienteCnpj + '\'' +
                ", produtoNsm=" + produtoNsm +
                ", data=" + data +
                ", valor=" + valor +
                '}';
    }
}
