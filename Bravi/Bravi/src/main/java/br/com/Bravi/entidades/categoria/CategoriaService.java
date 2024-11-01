package br.com.Bravi.entidades.categoria;

import java.util.List;

public interface CategoriaService {
    void inserir(Categoria categoria);
    void atualizar(Categoria categoria);
    void excluir(int id);
    List<Categoria> listar();
    Categoria buscarPorId(int id);
}
