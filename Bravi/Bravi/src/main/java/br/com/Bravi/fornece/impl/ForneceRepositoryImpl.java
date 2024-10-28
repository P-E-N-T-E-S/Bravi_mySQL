package br.com.Bravi.fornece.impl;

import br.com.Bravi.fornece.Fornece;
import br.com.Bravi.fornece.ForneceRepository;
import br.com.Bravi.fornece.mapper.MapperFornece;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ForneceRepositoryImpl implements ForneceRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperFornece mapperFornece;

    public ForneceRepositoryImpl(JdbcTemplate jdbcTemplate, MapperFornece mapperFornece) {
        this.jdbcTemplate = jdbcTemplate;
        this.mapperFornece = mapperFornece;
    }

    @Override
    public void inserir(Fornece fornece) {
        String sql = "INSERT INTO _Fornece (fk_Produto_NSM, fk_Fornecedor_CNPJ, data) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData());
    }

    @Override
    public void atualizar(Fornece fornece) {
        String sql = "UPDATE _Fornece SET fk_Produto_NSM = ?, fk_Fornecedor_CNPJ = ?, data = ? WHERE id = ?";
        jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData(), fornece.getId());
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM _Fornece WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Fornece> listar() {
        String sql = "SELECT * FROM _Fornece";
        return jdbcTemplate.query(sql, mapperFornece);
    }

    @Override
    public Fornece buscarPorId(int id) {
        String sql = "SELECT * FROM _Fornece WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapperFornece);
    }
}
