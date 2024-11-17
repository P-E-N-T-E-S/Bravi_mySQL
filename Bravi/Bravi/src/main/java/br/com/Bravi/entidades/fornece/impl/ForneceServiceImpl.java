package br.com.Bravi.entidades.fornece.impl;

import br.com.Bravi.entidades.fornece.Fornece;
import br.com.Bravi.entidades.fornece.ForneceRepository;
import br.com.Bravi.entidades.fornece.ForneceService;
import br.com.Bravi.exceptions.ForneceNaoEncontradoException;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForneceServiceImpl implements ForneceService {

    private final ForneceRepository forneceRepository;

    public ForneceServiceImpl(ForneceRepository forneceRepository) {
        this.forneceRepository = forneceRepository;
    }

    @Override
    public void inserirFornece(Fornece fornece) throws ProdutoNaoEncontradoException, FornecedorNaoEncontradoException {
        validarFornece(fornece);
        forneceRepository.inserir(fornece);
    }

    @Override
    public void atualizarFornece(Fornece fornece) throws ProdutoNaoEncontradoException, FornecedorNaoEncontradoException, ForneceNaoEncontradoException {
        validarFornece(fornece);
        forneceRepository.atualizar(fornece);
    }

    @Override
    public void excluirFornece(int id) throws ForneceNaoEncontradoException {
        Fornece fornece = forneceRepository.buscarPorId(id);
        if (fornece == null) {
            throw new ForneceNaoEncontradoException("Fornece com ID " + id + " não encontrado.");
        }
        forneceRepository.excluir(id);
    }

    @Override
    public List<Fornece> listarFornece() {
        return forneceRepository.listar();
    }

    @Override
    public Fornece buscarFornecePorId(int id) throws ForneceNaoEncontradoException {
        Fornece fornece = forneceRepository.buscarPorId(id);
        if (fornece == null) {
            throw new ForneceNaoEncontradoException("Fornece com ID " + id + " não encontrado.");
        }
        return fornece;
    }

    private void validarFornece(Fornece fornece) throws ProdutoNaoEncontradoException, FornecedorNaoEncontradoException {
        if (!fornecedorExiste(fornece.getFornecedorCnpj())) {
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado para o CNPJ: " + fornece.getFornecedorCnpj());
        }
    }

    private boolean fornecedorExiste(String cnpj) {
        return forneceRepository.fornecedorExiste(cnpj);
    }
}
