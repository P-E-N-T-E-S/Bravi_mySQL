package br.com.Bravi.fornecedor;

import java.util.List;

public interface FornecedorService {
    void adicionarFornecedor(Fornecedor fornecedor);
    void atualizarFornecedor(Fornecedor fornecedor);
    void removerFornecedor(String cnpj);
    List<Fornecedor> listarFornecedores();
    Fornecedor buscarFornecedorPorCNPJ(String cnpj);
}
