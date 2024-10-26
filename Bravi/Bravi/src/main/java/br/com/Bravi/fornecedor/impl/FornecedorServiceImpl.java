package br.com.Bravi.fornecedor.impl;

import br.com.Bravi.fornecedor.Fornecedor;
import br.com.Bravi.fornecedor.FornecedorRepository;
import br.com.Bravi.fornecedor.FornecedorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImpl implements FornecedorService {

    private final FornecedorRepository fornecedorRepository;

    public FornecedorServiceImpl(FornecedorRepository fornecedorRepository) {
        this.fornecedorRepository = fornecedorRepository;
    }

    @Override
    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.inserir(fornecedor);
    }

    @Override
    public void atualizarFornecedor(Fornecedor fornecedor) {
        fornecedorRepository.alterar(fornecedor);
    }

    @Override
    public void removerFornecedor(String cnpj) {
        fornecedorRepository.excluir(cnpj);
    }

    @Override
    public List<Fornecedor> listarFornecedores() {
        return fornecedorRepository.listar();
    }

    @Override
    public Fornecedor buscarFornecedorPorCNPJ(String cnpj) {
        return fornecedorRepository.buscarPorCNPJ(cnpj);
    }
}
