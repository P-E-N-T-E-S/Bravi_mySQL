package br.com.Bravi.entidades.compra.impl;

import br.com.Bravi.entidades.compra.Compra;
import br.com.Bravi.entidades.compra.CompraRepository;
import br.com.Bravi.entidades.compra.CompraService;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
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
        try {
            compraRepository.inserir(compra);
        } catch (DataIntegrityViolationException e) {
            throw new ClienteNaoEncontradoException("CNPJ do cliente não existe.");
        }
    }

    @Override
    public void atualizarCompra(Compra compra) {
        if (compraRepository.buscarPorId(compra.getId()) == null) {
            throw new ClienteNaoEncontradoException("Compra não encontrada.");
        }
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
        try {
            return compraRepository.buscarPorId(id);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
}
