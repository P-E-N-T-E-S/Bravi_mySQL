package br.com.Bravi.entidades.compra.impl;

import br.com.Bravi.entidades.compra.Compra;
import br.com.Bravi.entidades.compra.CompraRepository;
import br.com.Bravi.entidades.compra.CompraService;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import br.com.Bravi.exceptions.CompraNaoEncontradaException;
import br.com.Bravi.exceptions.InternalServerErrorException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import br.com.Bravi.exceptions.EstoqueInsuficienteException;
import org.springframework.dao.DataIntegrityViolationException;
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
        } catch (ProdutoNaoEncontradoException e) {
            throw new ProdutoNaoEncontradoException("Não foi possível realizar a compra, produto não encontrado.");
        } catch (EstoqueInsuficienteException e) {
            throw new EstoqueInsuficienteException("Não foi possível realizar a compra, estoque insuficiente.");
        } catch (DataIntegrityViolationException e) {
            throw new ClienteNaoEncontradoException("CNPJ do cliente não existe.");
        }
    }

    @Override
    public void atualizarCompra(Compra compra) {
        Compra compraExistente = compraRepository.buscarPorId(compra.getId());
        if (compraExistente == null) {
            throw new CompraNaoEncontradaException("Compra não encontrada.");
        }
        try {
            compraRepository.atualizar(compra);
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro ao atualizar a compra.");
        }
    }

    @Override
    public void excluirCompra(int id) {
        try {
            Compra compra = compraRepository.buscarPorId(id);
            if (compra == null) {
                throw new CompraNaoEncontradaException("Compra não encontrada.");
            }
            compraRepository.excluir(id);
        } catch (CompraNaoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro interno ao excluir a compra.");
        }
    }

    @Override
    public List<Compra> listarCompra() {
        return compraRepository.listar();
    }

    @Override
    public Compra buscarCompraPorId(int id) {
        try {
            return compraRepository.buscarPorId(id);
        } catch (CompraNaoEncontradaException e) {
            throw e;
        } catch (Exception e) {
            throw new InternalServerErrorException("Erro interno ao buscar compra.");
        }
    }
}
