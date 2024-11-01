package br.com.Bravi.entidades.estoque.impl;

import br.com.Bravi.entidades.estoque.Estoque;
import br.com.Bravi.entidades.estoque.EstoqueRepository;
import br.com.Bravi.entidades.estoque.EstoqueService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueServiceImpl implements EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public EstoqueServiceImpl(EstoqueRepository estoqueRepository) {
        this.estoqueRepository = estoqueRepository;
    }

    @Override
    public void adicionarEstoque(Estoque estoque) {
        estoqueRepository.inserir(estoque);
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
        return estoqueRepository.listar();
    }

    @Override
    public Estoque buscarEstoquePorId(int setor, int produtoNsm) {
        return estoqueRepository.buscarPorId(setor, produtoNsm);
    }
}
