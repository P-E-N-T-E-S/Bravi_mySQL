package br.com.Bravi.entidades.cliente;

import java.util.List;

public interface ClienteService {
    void inserir(Cliente cliente);
    void alterar(Cliente cliente);
    void excluir(String cnpj);
    List<Cliente> listar();
    Cliente buscarPorCNPJ(String cnpj);
}