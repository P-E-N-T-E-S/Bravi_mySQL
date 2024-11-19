package br.com.Bravi.entidades.categoria_produto;

import br.com.Bravi.entidades.categoria.Categoria;

import java.util.List;

public interface CategoriaProdutoRepository {
    List<Categoria> buscarCategoriaPorProduto(int nsm);
    void adicionarCategoriaProduto(CategoriaProduto categoriaProduto);
}
