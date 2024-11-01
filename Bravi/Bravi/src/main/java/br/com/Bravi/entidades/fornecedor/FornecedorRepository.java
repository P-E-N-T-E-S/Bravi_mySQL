package br.com.Bravi.entidades.fornecedor;

import java.util.List;

public interface FornecedorRepository {
    void inserir(Fornecedor fornecedor);
    void alterar(Fornecedor fornecedor);
    void excluir(String cnpj);
    List<Fornecedor> listar();
    Fornecedor buscarPorCNPJ(String cnpj);
}
