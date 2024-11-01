package br.com.Bravi.entidades.compra;

import java.util.List;

public interface CompraRepository {

    void inserir(Compra compra);

    void atualizar(Compra compra);

    void excluir(int id);

    List<Compra> listar();

    Compra buscarPorId(int id);
}
