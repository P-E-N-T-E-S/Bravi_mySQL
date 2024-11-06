package br.com.Bravi.produto.impl;

import br.com.Bravi.produto.Produto;
import br.com.Bravi.produto.ProdutoRepository;
import br.com.Bravi.produto.ProdutoService;
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
        produtoRepository.alterar(produto);
    }

    @Override
    public void removerProduto(int nsm) {
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