package br.com.Bravi.entidades.categoria;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    void inserir(Categoria categoria);
    void atualizar(Categoria categoria);
    void excluir(int id);
    List<Categoria> listar();
    Optional<Categoria> buscarPorId(int id);
    boolean existsById(int id);
}
