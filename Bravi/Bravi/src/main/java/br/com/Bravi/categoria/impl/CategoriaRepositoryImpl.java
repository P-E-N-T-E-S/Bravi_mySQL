package br.com.Bravi.categoria.impl;

import br.com.Bravi.categoria.Categoria;
import br.com.Bravi.categoria.CategoriaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import br.com.Bravi.categoria.mapper.MapperCategoria;

import java.util.List;

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
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Categoria> listar() {
        String sql = "SELECT * FROM Categoria";
        return jdbcTemplate.query(sql, (rs, rowNum) -> categoriaMapper.mapRow(rs));
    }

    @Override
    public Categoria buscarPorId(int id) {
        String sql = "SELECT * FROM Categoria WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> categoriaMapper.mapRow(rs));
    }
}
