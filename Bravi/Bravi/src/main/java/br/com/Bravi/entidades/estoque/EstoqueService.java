package br.com.Bravi.entidades.estoque;

import java.util.List;

public interface EstoqueService {
    void adicionarEstoque(Estoque estoque);
    void atualizarEstoque(Estoque estoque);
    void removerEstoque(int setor, int produtoNsm);
    List<Estoque> listarEstoque();
    Estoque buscarEstoquePorId(int setor, int produtoNsm);
}
