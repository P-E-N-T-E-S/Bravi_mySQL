package br.com.Bravi.compra.impl;

import br.com.Bravi.compra.Compra;
import br.com.Bravi.compra.CompraRepository;
import br.com.Bravi.compra.CompraService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;

    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public void inserirCompra(Compra compra) {
        compraRepository.inserir(compra);
    }

    @Override
    public void atualizarCompra(Compra compra) {
        compraRepository.atualizar(compra);
    }

    @Override
    public void excluirCompra(int id) {
        compraRepository.excluir(id);
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepository.listar();
    }

    @Override
    public Compra buscarCompraPorId(int id) {
        return compraRepository.buscarPorId(id);
    }
}
