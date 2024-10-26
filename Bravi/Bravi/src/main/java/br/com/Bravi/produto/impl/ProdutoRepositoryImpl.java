package br.com.Bravi.produto.impl;

import br.com.Bravi.produto.Produto;
import br.com.Bravi.produto.ProdutoRepository;
import br.com.Bravi.produto.mapper.MapperProduto;
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
        String sql = "INSERT INTO Produto (Nome, Descrição) VALUES (?, ?)";
        jdbcTemplate.update(sql, produto.getNome(), produto.getDescricao());
    }

    @Override
    public void alterar(Produto produto) {
        String sql = "UPDATE Produto SET Nome = ?, Descrição = ? WHERE NSM = ?";
        jdbcTemplate.update(sql, produto.getNome(), produto.getDescricao(), produto.getNsm());
    }

    @Override
    public void excluir(int nsm) {
        String sql = "DELETE FROM Produto WHERE NSM = ?";
        jdbcTemplate.update(sql, nsm);
    }

    @Override
    public List<Produto> listar() {
        String sql = "SELECT * FROM Produto";
        return jdbcTemplate.query(sql, produtoMapper);
    }

    @Override
    public Produto buscarPorNsm(int nsm) {
        String sql = "SELECT * FROM Produto WHERE NSM = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nsm}, produtoMapper);
    }
}
