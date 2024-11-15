package br.com.Bravi.entidades.cliente;

import br.com.Bravi.entidades.pj.PJ;

public class Cliente extends PJ {
    private String nome;

    public Cliente(String cnpj, String nome, String rua, String bairro, String cep, String numero, String numero2, String inscricaoEstadual, String razaoSocial) {
        super(cnpj, rua, bairro, cep, numero, numero2, inscricaoEstadual, razaoSocial);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
