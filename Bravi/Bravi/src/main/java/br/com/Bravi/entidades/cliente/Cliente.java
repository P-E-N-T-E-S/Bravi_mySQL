package br.com.Bravi.entidades.cliente;

import br.com.Bravi.entidades.pj.PJ;

public class Cliente extends PJ {

    public Cliente(String cnpj, String rua, String bairro, int cep, int numero, int inscricaoEstadual, String razaoSocial) {
        super(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
    }

    public Cliente() {}

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                '}';
    }
}
