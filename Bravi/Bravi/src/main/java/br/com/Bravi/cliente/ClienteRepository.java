package br.com.Bravi.cliente;

import java.util.List;

public interface ClienteRepository {
    void inserir(Cliente cliente);
    void alterar(Cliente cliente);
    void excluir(String cnpj);
    List<Cliente> listar();
    Cliente buscarPorCNPJ(String cnpj);
}
