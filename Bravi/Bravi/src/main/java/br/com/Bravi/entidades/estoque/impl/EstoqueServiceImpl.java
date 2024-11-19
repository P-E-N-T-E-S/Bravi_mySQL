package br.com.Bravi.entidades.estoque.impl;

import br.com.Bravi.entidades.estoque.Estoque;
import br.com.Bravi.entidades.estoque.EstoqueRepository;
import br.com.Bravi.entidades.estoque.EstoqueService;
import br.com.Bravi.entidades.produto.ProdutoService;
import br.com.Bravi.exceptions.EstoqueNotFoundException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;
    private final ProdutoService produtoService;

    public EstoqueServiceImpl(EstoqueRepository estoqueRepository, ProdutoService produtoService) {
        this.estoqueRepository = estoqueRepository;
        this.produtoService = produtoService;
    }

    @Override
    public void adicionarEstoque(Estoque estoque) {
        try {
            estoqueRepository.inserir(estoque);
        } catch (DataIntegrityViolationException e) {
            throw new ProdutoNaoEncontradoException("Produto com NSM " + estoque.getProdutoNsm() + " não encontrado.");
        }
    }

    @Override
    public void atualizarEstoque(Estoque estoque) {
        estoqueRepository.atualizar(estoque);
    }

    @Override
    public void removerEstoque(int setor, int produtoNsm) {
        estoqueRepository.excluir(setor, produtoNsm);
    }

    @Override
    public List<Estoque> listarEstoque() {
        List<Estoque> query = estoqueRepository.listar();
        for (Estoque estoque : query) {
            estoque.setProduto(produtoService.obterProdutoPorNsm(estoque.getProdutoNsm()));
        }
        return query;
    }

    @Override
    public Estoque buscarEstoquePorId(int setor, int produtoNsm) {
        Estoque estoque = estoqueRepository.buscarPorId(setor, produtoNsm);
        if (estoque == null) {
            throw new EstoqueNotFoundException("Estoque não encontrado para setor " + setor + " e produto NSM " + produtoNsm);
        }
        estoque.setProduto(produtoService.obterProdutoPorNsm(estoque.getProdutoNsm()));
        return estoque;
    }
}
