package br.com.Bravi.entidades.produto.impl;

import br.com.Bravi.entidades.produto.Produto;
import br.com.Bravi.entidades.produto.ProdutoRepository;
import br.com.Bravi.entidades.produto.ProdutoService;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtoRepository.inserir(produto);
    }

    @Override
    public void atualizarProduto(Produto produto) {
        Produto produtoExistente = produtoRepository.buscarPorNsm(produto.getNsm());
        if (produtoExistente == null) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado para o NSM " + produto.getNsm());
        }
        produtoRepository.alterar(produto);
    }

    @Override
    public void removerProduto(int nsm) {
        Produto produtoExistente = produtoRepository.buscarPorNsm(nsm);
        if (produtoExistente == null) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado para o NSM " + nsm);
        }
        produtoRepository.excluir(nsm);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.listar();
    }

    @Override
    public Produto obterProdutoPorNsm(int nsm) {
        return produtoRepository.buscarPorNsm(nsm);
    }
}
