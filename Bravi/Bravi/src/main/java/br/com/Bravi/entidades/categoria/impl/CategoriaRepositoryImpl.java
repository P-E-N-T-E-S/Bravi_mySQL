package br.com.Bravi.entidades.categoria.impl;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.categoria.CategoriaRepository;
import br.com.Bravi.entidades.categoria.mapper.MapperCategoria;
import br.com.Bravi.exceptions.CategoriaNaoEncontradaException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperCategoria categoriaMapper;

    public CategoriaRepositoryImpl(JdbcTemplate jdbcTemplate, MapperCategoria categoriaMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.categoriaMapper = categoriaMapper;
    }

    @Override
    public void inserir(Categoria categoria) {
        String sql = "INSERT INTO Categoria (nome) VALUES (?)";
        jdbcTemplate.update(sql, categoria.getNome());
    }

    @Override
    public void atualizar(Categoria categoria) {
        String sql = "UPDATE Categoria SET nome = ? WHERE id = ?";
        jdbcTemplate.update(sql, categoria.getNome(), categoria.getId());
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM Categoria WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);

        if (rowsAffected == 0) {
            throw new CategoriaNaoEncontradaException("Categoria com ID " + id + " não encontrada.");
        }
    }

    @Override
    public List<Categoria> listar() {
        String sql = "SELECT * FROM Categoria";
        return jdbcTemplate.query(sql, (rs, rowNum) -> categoriaMapper.mapRow(rs, rowNum));
    }

    @Override
    public Optional<Categoria> buscarPorId(int id) {
        String sql = "SELECT * FROM Categoria WHERE id = ?";
        try {
            Categoria categoria = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> categoriaMapper.mapRow(rs, rowNum));
            return Optional.ofNullable(categoria);
        } catch (EmptyResultDataAccessException e) {
            throw new CategoriaNaoEncontradaException("Categoria com ID " + id + " não encontrada: " + e.getMessage());
        }
    }

    @Override
    public Categoria buscarPorNome(String nome) {
        String sql = "SELECT * FROM Categoria WHERE nome = ?";
        return jdbcTemplate.queryForObject(sql, new MapperCategoria(), nome);
    }

    @Override
    public boolean existsById(int id) {
        String sql = "SELECT COUNT(*) FROM Categoria WHERE id = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, id);
        return count != null && count > 0;
    }
}
