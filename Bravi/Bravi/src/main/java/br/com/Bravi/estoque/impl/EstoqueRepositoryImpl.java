package br.com.Bravi.estoque.impl;

import br.com.Bravi.estoque.Estoque;
import br.com.Bravi.estoque.EstoqueRepository;
import br.com.Bravi.estoque.mapper.MapperEstoque;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EstoqueRepositoryImpl implements EstoqueRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperEstoque mapper;

    public EstoqueRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapper = new MapperEstoque();
    }

    @Override
    public void inserir(Estoque estoque) {
        String sql = "INSERT INTO Estoque (setor, qtd, fk_Produto_NSM) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, mapper.mapEstoqueToParams(estoque));
    }

    @Override
    public void atualizar(Estoque estoque) {
        String sql = "UPDATE Estoque SET qtd = ? WHERE setor = ? AND fk_Produto_NSM = ?";
        jdbcTemplate.update(sql, estoque.getQtd(), estoque.getSetor(), estoque.getProdutoNsm());
    }

    @Override
    public void excluir(int setor, int produtoNsm) {
        String sql = "DELETE FROM Estoque WHERE setor = ? AND fk_Produto_NSM = ?";
        jdbcTemplate.update(sql, setor, produtoNsm);
    }

    @Override
    public List<Estoque> listar() {
        String sql = "SELECT * FROM Estoque";
        return jdbcTemplate.query(sql, this::mapRowToEstoque);
    }

    @Override
    public Estoque buscarPorId(int setor, int produtoNsm) {
        String sql = "SELECT * FROM Estoque WHERE setor = ? AND fk_Produto_NSM = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{setor, produtoNsm}, this::mapRowToEstoque);
    }

    private Estoque mapRowToEstoque(ResultSet rs, int rowNum) throws SQLException {
        return mapper.mapRowToEstoque(rs);
    }
}
