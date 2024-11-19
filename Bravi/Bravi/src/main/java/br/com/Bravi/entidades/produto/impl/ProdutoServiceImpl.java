package br.com.Bravi.entidades.produto.impl;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.categoria_produto.CategoriaProduto;
import br.com.Bravi.entidades.categoria_produto.CategoriaProdutoService;
import br.com.Bravi.entidades.produto.Produto;
import br.com.Bravi.entidades.produto.ProdutoRepository;
import br.com.Bravi.entidades.produto.ProdutoService;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    private final CategoriaProdutoService categoriaProdutoService;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository, CategoriaProdutoService categoriaProdutoService) {
        this.produtoRepository = produtoRepository;
        this.categoriaProdutoService = categoriaProdutoService;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtoRepository.inserir(produto);
        if (produto.getCategoria() != null) {
            for (Categoria categoria : produto.getCategoria()) {
                categoriaProdutoService.adicionarCategoriaProduto(new CategoriaProduto(produto.getNsm(), categoria.getId()));
            }
        }
    }

    @Override
    public void atualizarProduto(Produto produto, int nsm) {
        produto.setNsm(nsm);
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
        List<Produto> query = produtoRepository.listar();
        for (Produto produto : query) {
            produto.setCategoria(categoriaProdutoService.buscarCategoriaPorProduto(produto.getNsm()));
        }
        return query;
    }

    @Override
    public Produto obterProdutoPorNsm(int nsm) {
        Produto query = produtoRepository.buscarPorNsm(nsm);
        query.setCategoria(categoriaProdutoService.buscarCategoriaPorProduto(query.getNsm()));
        return query;
    }
}
