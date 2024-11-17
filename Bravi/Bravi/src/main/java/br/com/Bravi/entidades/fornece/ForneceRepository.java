package br.com.Bravi.entidades.fornece;

import java.util.List;

public interface ForneceRepository {

    void inserir(Fornece fornece);

    void atualizar(Fornece fornece);

    void excluir(int id);

    List<Fornece> listar();

    Fornece buscarPorId(int id);

    boolean fornecedorExiste(String cnpj);
}
