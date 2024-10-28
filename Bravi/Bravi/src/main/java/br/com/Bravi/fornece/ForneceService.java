package br.com.Bravi.fornece;

import java.util.List;

public interface ForneceService {

    void inserirFornece(Fornece fornece);

    void atualizarFornece(Fornece fornece);

    void excluirFornece(int id);

    List<Fornece> listarFornece();

    Fornece buscarFornecePorId(int id);
}
