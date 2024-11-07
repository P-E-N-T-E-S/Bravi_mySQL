package br.com.Bravi.entidades.cliente;

import br.com.Bravi.entidades.pj.PJ;

public class Cliente extends PJ {

    private String nome;

    public Cliente(String cnpj, String rua, String bairro, String cep, int numero, String inscricaoEstadual, String razaoSocial, String nome) {
        super(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
        this.nome = nome;
    }

    public Cliente() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                super.toString() +
                '}';
    }
}
