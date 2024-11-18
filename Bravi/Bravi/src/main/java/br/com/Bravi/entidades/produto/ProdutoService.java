package br.com.Bravi.entidades.produto;

import java.util.List;

public interface ProdutoService {
    void adicionarProduto(Produto produto);
    void atualizarProduto(Produto produto, int nsm);
    void removerProduto(int nsm);
    List<Produto> listarProdutos();
    Produto obterProdutoPorNsm(int nsm);
}
