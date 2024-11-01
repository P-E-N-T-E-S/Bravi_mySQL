package br.com.Bravi.entidades.compra;

import java.util.List;

public interface CompraService {

    void inserirCompra(Compra compra);

    void atualizarCompra(Compra compra);

    void excluirCompra(int id);

    List<Compra> listarCompra();

    Compra buscarCompraPorId(int id);
}
