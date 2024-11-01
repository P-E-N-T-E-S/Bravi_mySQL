package br.com.Bravi.entidades.compra.impl;

import br.com.Bravi.entidades.compra.Compra;
import br.com.Bravi.entidades.compra.CompraRepository;
import br.com.Bravi.entidades.compra.mapper.MapperCompra;
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
        String sql = "INSERT INTO _Compra (fk_Cliente_CNPJ, fk_Produto_NSM, data) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, compra.getClienteCnpj(), compra.getProdutoNsm(), compra.getData());
    }

    @Override
    public void atualizar(Compra compra) {
        String sql = "UPDATE _Compra SET fk_Cliente_CNPJ = ?, fk_Produto_NSM = ?, data = ? WHERE id = ?";
        jdbcTemplate.update(sql, compra.getClienteCnpj(), compra.getProdutoNsm(), compra.getData(), compra.getId());
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM _Compra WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Compra> listar() {
        String sql = "SELECT * FROM _Compra";
        return jdbcTemplate.query(sql, mapperCompra);
    }

    @Override
    public Compra buscarPorId(int id) {
        String sql = "SELECT * FROM _Compra WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapperCompra);
    }
}
