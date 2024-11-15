package br.com.Bravi.entidades.fornece;

import br.com.Bravi.exceptions.ForneceNaoEncontradoException;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;

import java.util.List;

public interface ForneceService {

    void inserirFornece(Fornece fornece) throws ProdutoNaoEncontradoException, FornecedorNaoEncontradoException;

    void atualizarFornece(Fornece fornece) throws ProdutoNaoEncontradoException, FornecedorNaoEncontradoException, ForneceNaoEncontradoException;

    void excluirFornece(int id) throws ForneceNaoEncontradoException;

    List<Fornece> listarFornece();

    Fornece buscarFornecePorId(int id) throws ForneceNaoEncontradoException;
}
