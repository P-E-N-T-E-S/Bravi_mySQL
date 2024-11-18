package br.com.Bravi.entidades.categoria_produto.impl;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.categoria.mapper.MapperCategoria;
import br.com.Bravi.entidades.categoria_produto.CategoriaProduto;
import br.com.Bravi.entidades.categoria_produto.CategoriaProdutoRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaProdutoRepositoryImpl implements CategoriaProdutoRepository {

    private JdbcTemplate jdbcTemplate;

    public CategoriaProdutoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Categoria> buscarCategoriaPorProduto(int nsm) {
        String sql = "SELECT * FROM Categoria_Produto JOIN Categoria C on Categoria_Produto.fk_Categoria_id = C.id";
        return jdbcTemplate.query(sql, new MapperCategoria());
    }

    @Override
    public void adicionarCategoriaProduto(CategoriaProduto categoriaProduto) {
        String sql = "INSERT INTO Categoria_Produto (fk_Produto_NSM, fk_Categoria_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, categoriaProduto.getNsm(), categoriaProduto.getIdCategoria());
    }
}
