package br.com.Bravi.entidades.compra.impl;

import br.com.Bravi.entidades.compra.Compra;
import br.com.Bravi.entidades.compra.CompraRepository;
import br.com.Bravi.entidades.compra.mapper.MapperCompra;
import br.com.Bravi.exceptions.CompraNaoEncontradaException;
import br.com.Bravi.exceptions.InternalServerErrorException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import br.com.Bravi.exceptions.EstoqueInsuficienteException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompraRepositoryImpl implements CompraRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperCompra mapperCompra;

    public CompraRepositoryImpl(JdbcTemplate jdbcTemplate, MapperCompra mapperCompra) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapperCompra = mapperCompra;
    }

    @Override
    public void inserir(Compra compra) {
        if (!produtoExiste(compra.getProdutoNsm())) {
            throw new ProdutoNaoEncontradoException("Produto com NSM " + compra.getProdutoNsm() + " não encontrado.");
        }

        if (!estoqueSuficiente(compra.getProdutoNsm())) {
            throw new EstoqueInsuficienteException("Estoque insuficiente para o produto com NSM " + compra.getProdutoNsm());
        }

        String sql = "INSERT INTO _Compra (fk_Cliente_CNPJ, fk_Produto_NSM, data, valor) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, compra.getClienteCnpj(), compra.getProdutoNsm(), compra.getData(), compra.getValor());
    }

    @Override
    public void atualizar(Compra compra) {
        String sql = "UPDATE _Compra SET fk_Cliente_CNPJ = ?, fk_Produto_NSM = ?, data = ?, valor = ? WHERE id = ?";
        jdbcTemplate.update(sql, compra.getClienteCnpj(), compra.getProdutoNsm(), compra.getData(), compra.getValor(), compra.getId());
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM _Compra WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected == 0) {
            throw new CompraNaoEncontradaException("Compra com ID " + id + " não encontrada para exclusão.");
        }
    }

    @Override
    public List<Compra> listar() {
        String sql = "SELECT * FROM _Compra";
        return jdbcTemplate.query(sql, mapperCompra);
    }

    @Override
    public Compra buscarPorId(int id) {
        String sql = "SELECT * FROM _Compra WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapperCompra);
        } catch (EmptyResultDataAccessException e) {
            throw new CompraNaoEncontradaException("Compra com ID " + id + " não encontrada.");
        }
    }

    private boolean produtoExiste(int nsm) {
        String sql = "SELECT COUNT(*) FROM Produto WHERE NSM = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{nsm}, Integer.class);
        return count != null && count > 0;
    }

    private boolean estoqueSuficiente(int nsm) {
        String sql = "SELECT qtd FROM Estoque WHERE produtoNsm = ?";
        Integer estoque = jdbcTemplate.queryForObject(sql, new Object[]{nsm}, Integer.class);
        return estoque != null && estoque > 0;
    }
}
