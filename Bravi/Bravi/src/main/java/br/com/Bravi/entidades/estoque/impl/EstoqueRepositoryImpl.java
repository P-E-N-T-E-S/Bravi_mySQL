package br.com.Bravi.entidades.estoque.impl;

import br.com.Bravi.entidades.estoque.Estoque;
import br.com.Bravi.entidades.estoque.EstoqueRepository;
import br.com.Bravi.entidades.estoque.mapper.MapperEstoque;
import br.com.Bravi.exceptions.EstoqueNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EstoqueRepositoryImpl implements EstoqueRepository {

    private final JdbcTemplate jdbcTemplate;

    public EstoqueRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void inserir(Estoque estoque) {
        String sql = "INSERT INTO Estoque (fk_Setor_id, qtd, fk_Produto_NSM) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, estoque.getIdSetor(), estoque.getQtd(), estoque.getProdutoNsm());
    }

    @Override
    public void atualizar(Estoque estoque) {
        String sql = "UPDATE Estoque SET qtd = ? WHERE fk_Setor_id = ? AND fk_Produto_NSM = ?";
        jdbcTemplate.update(sql, estoque.getQtd(), estoque.getIdSetor(), estoque.getProdutoNsm());
    }

    @Override
    public void excluir(int setor, int produtoNsm) {
        String sql = "DELETE FROM Estoque WHERE fk_Setor_id = ? AND fk_Produto_NSM = ?";
        jdbcTemplate.update(sql, setor, produtoNsm);
    }

    @Override
    public Estoque buscarPorId(int setor, int produtoNsm) {
        String sql = "SELECT e.*, p.nome AS produto_nome, s.nome AS setor_nome " +
                "FROM Estoque e " +
                "JOIN Produto p ON e.fk_Produto_NSM = p.nsm " +
                "JOIN Setor s ON e.fk_Setor_id = s.id " +
                "WHERE e.fk_Setor_id = ? AND e.fk_Produto_NSM = ?";

        try {
            return jdbcTemplate.queryForObject(sql, new MapperEstoque(), setor, produtoNsm);
        } catch (EmptyResultDataAccessException e) {
            throw new EstoqueNotFoundException("Estoque com setor " + setor + " e produto NSM " + produtoNsm + " não encontrado.");
        }
    }

    @Override
    public List<Estoque> listar() {
        String sql = "SELECT e.*, p.nome AS produto_nome, s.nome AS setor_nome FROM Estoque e JOIN Produto p ON e.fk_Produto_NSM = p.nsm JOIN Setor s ON e.fk_Setor_id = s.id";
        return jdbcTemplate.query(sql, new MapperEstoque());
    }
}
