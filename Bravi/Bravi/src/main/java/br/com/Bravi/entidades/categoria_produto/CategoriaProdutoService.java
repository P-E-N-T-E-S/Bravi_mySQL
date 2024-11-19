package br.com.Bravi.entidades.categoria_produto;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.produto.Produto;

import java.util.List;

public interface CategoriaProdutoService {
    List<Categoria> buscarCategoriaPorProduto(int nsm);
    void adicionarCategoriaProduto(CategoriaProduto categoriaProduto);
}
