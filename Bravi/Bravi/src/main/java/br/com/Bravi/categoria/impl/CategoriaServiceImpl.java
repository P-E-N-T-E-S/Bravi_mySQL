package br.com.Bravi.categoria.impl;

import br.com.Bravi.categoria.Categoria;
import br.com.Bravi.categoria.CategoriaRepository;
import br.com.Bravi.categoria.CategoriaService;
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
        categoriaRepository.atualizar(categoria);
    }

    @Override
    public void excluir(int id) {
        categoriaRepository.excluir(id);
    }

    @Override
    public List<Categoria> listar() {
        return categoriaRepository.listar();
    }

    @Override
    public Categoria buscarPorId(int id) {
        return categoriaRepository.buscarPorId(id);
    }
}
