package br.com.Bravi.estoque;

import java.util.List;

public interface EstoqueRepository {
    void inserir(Estoque estoque);
    void atualizar(Estoque estoque);
    void excluir(int setor, int produtoNsm);
    List<Estoque> listar();
    Estoque buscarPorId(int setor, int produtoNsm);
}
