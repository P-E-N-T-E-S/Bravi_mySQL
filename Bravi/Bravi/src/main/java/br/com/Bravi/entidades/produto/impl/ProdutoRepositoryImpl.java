package br.com.Bravi.entidades.produto.impl;

import br.com.Bravi.entidades.produto.Produto;
import br.com.Bravi.entidades.produto.ProdutoRepository;
import br.com.Bravi.entidades.produto.mapper.MapperProduto;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperProduto produtoMapper;

    public ProdutoRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.produtoMapper = new MapperProduto();
    }

    @Override
    public void inserir(Produto produto) {
        String sql = "INSERT INTO Produto (Nome, Descrição, fk_Categoria_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql,
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoriaId());
    }

    @Override
    public void alterar(Produto produto) {
        String sql = "UPDATE Produto SET Nome = ?, Descrição = ?, fk_Categoria_id = ? WHERE NSM = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                produto.getNome(),
                produto.getDescricao(),
                produto.getCategoriaId(),
                produto.getNsm());

        if (rowsAffected == 0) {
            throw new ProdutoNaoEncontradoException("Produto com NSM " + produto.getNsm() + " não encontrado.");
        }
    }

    @Override
    public void excluir(int nsm) {
        String sql = "DELETE FROM Produto WHERE NSM = ?";
        int rowsAffected = jdbcTemplate.update(sql, nsm);

        if (rowsAffected == 0) {
            throw new ProdutoNaoEncontradoException("Produto com NSM " + nsm + " não encontrado.");
        }
    }

    @Override
    public List<Produto> listar() {
        String sql = "SELECT p.NSM, p.Nome, p.Descrição, p.fk_Categoria_id, c.nome AS categoria_nome " +
                "FROM Produto p " +
                "LEFT JOIN Categoria c ON p.fk_Categoria_id = c.id";
        return jdbcTemplate.query(sql, produtoMapper);
    }

    @Override
    public Produto buscarPorNsm(int nsm) {
        String sql = "SELECT p.NSM, p.Nome, p.Descrição, p.fk_Categoria_id, c.nome AS categoria_nome " +
                "FROM Produto p " +
                "LEFT JOIN Categoria c ON p.fk_Categoria_id = c.id " +
                "WHERE p.NSM = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{nsm}, produtoMapper);
        } catch (EmptyResultDataAccessException e) {
            throw new ProdutoNaoEncontradoException("Produto com NSM " + nsm + " não encontrado.");
        }
    }
}
