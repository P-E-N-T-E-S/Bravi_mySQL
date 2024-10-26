package br.com.Bravi.produto;

import java.util.List;

public interface ProdutoService {
    void adicionarProduto(Produto produto);
    void atualizarProduto(Produto produto);
    void removerProduto(int nsm);
    List<Produto> listarProdutos();
    Produto obterProdutoPorNsm(int nsm);
}
