package br.com.Bravi.entidades.categoria.impl;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.categoria.CategoriaRepository;
import br.com.Bravi.entidades.categoria.CategoriaService;
import br.com.Bravi.exceptions.CategoriaNaoEncontradaException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void inserir(Categoria categoria) {
        categoriaRepository.inserir(categoria);
    }

    @Override
    public void atualizar(Categoria categoria) {
        if (!categoriaRepository.existsById(categoria.getId())) {
            throw new CategoriaNaoEncontradaException("Categoria com ID " + categoria.getId() + " não encontrada");
        }
        categoriaRepository.atualizar(categoria);
    }

    @Override
    public void excluir(int id) {
        if (!categoriaRepository.existsById(id)) {
            throw new CategoriaNaoEncontradaException("Categoria com ID " + id + " não encontrada");
        }
        categoriaRepository.excluir(id);
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.listar();
    }

    @Override
    public Categoria buscarPorId(int id) {
        return categoriaRepository.buscarPorId(id)
                .orElseThrow(() -> new CategoriaNaoEncontradaException("Categoria com ID " + id + " não encontrada"));
    }

    @Override
    public Categoria buscarPorNome(String nome) {
        return categoriaRepository.buscarPorNome(nome);
    }
}
