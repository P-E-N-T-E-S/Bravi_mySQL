package br.com.Bravi.entidades.fornecedor;

import br.com.Bravi.entidades.pj.PJ;

public class Fornecedor extends PJ {

    private String categoria;

    public Fornecedor(String categoria, String cnpj, String rua, String bairro, int cep,
                      int numero, int inscricaoEstadual, String razaoSocial) {
        super(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
        this.categoria = categoria;
    }

    public Fornecedor() {}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "categoria='" + categoria + '\'' +
                ", cnpj='" + getCnpj() + '\'' +
                ", rua='" + getRua() + '\'' +
                ", bairro='" + getBairro() + '\'' +
                ", cep=" + getCep() +
                ", numero=" + getNumero() +
                ", inscricaoEstadual=" + getInscricaoEstadual() +
                ", razaoSocial='" + getRazaoSocial() + '\'' +
                '}';
    }
}
