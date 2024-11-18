package br.com.Bravi.entidades.categoria_produto.impl;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.categoria_produto.CategoriaProduto;
import br.com.Bravi.entidades.categoria_produto.CategoriaProdutoRepository;
import br.com.Bravi.entidades.categoria_produto.CategoriaProdutoService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaProdutoServiceImpl implements CategoriaProdutoService {

    private final CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaProdutoServiceImpl(CategoriaProdutoRepository categoriaProdutoRepository) {
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @Override
    public List<Categoria> buscarCategoriaPorProduto(int nsm) {
        return categoriaProdutoRepository.buscarCategoriaPorProduto(nsm);
    }

    @Override
    public void adicionarCategoriaProduto(CategoriaProduto categoriaProduto) {
        categoriaProdutoRepository.adicionarCategoriaProduto(categoriaProduto);
    }
}
