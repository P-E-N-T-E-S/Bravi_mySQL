package br.com.Bravi.entidades.produto;

import java.util.List;

public interface ProdutoRepository {
    void inserir(Produto produto);
    void alterar(Produto produto);
    void excluir(int nsm);
    List<Produto> listar();
    Produto buscarPorNsm(int nsm);
}
