package br.com.Bravi.entidades.fornecedor;

import br.com.Bravi.entidades.pj.PJ;

public class Fornecedor extends PJ {

    private String categoria;
    private String inscricaoEstadual;

    public Fornecedor(String categoria, String cnpj, String rua, String bairro, String cep,
                      String numero, String numero2, String inscricaoEstadual, String razaoSocial) {
        super(cnpj, rua, bairro, cep, numero, numero2, inscricaoEstadual, razaoSocial);
        this.categoria = categoria;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public Fornecedor() {}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "categoria='" + categoria + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", rua='" + getRua() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cep=" + getCep() +
                ", numero=" + getNumero() +
                ", numero2=" + getNumero() +
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                '}';
    }
}