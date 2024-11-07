package br.com.Bravi.entidades.fornecedor;

import br.com.Bravi.entidades.pj.PJ;

public class Fornecedor extends PJ {

    private String categoria;
    private String inscricaoEstadual;  // Mudado para String

    public Fornecedor(String categoria, String cnpj, String rua, String bairro, String cep,
                      int numero, String inscricaoEstadual, String razaoSocial) {
        super(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
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
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                '}';
    }
}
