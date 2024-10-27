package br.com.Bravi.categoria;

import java.util.List;

public interface CategoriaService {
    void inserir(Categoria categoria);
    void atualizar(Categoria categoria);
    void excluir(int id);
    List<Categoria> listar();
    Categoria buscarPorId(int id);
}
