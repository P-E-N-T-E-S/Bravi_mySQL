package br.com.Bravi.entidades.fornece.impl;

import br.com.Bravi.entidades.fornece.Fornece;
import br.com.Bravi.entidades.fornece.ForneceRepository;
import br.com.Bravi.entidades.fornece.mapper.MapperFornece;
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
        String sql = "INSERT INTO _Fornece (fk_Produto_NSM, fk_Fornecedor_CNPJ, data, valor) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData(), fornece.getValor());
    }

    @Override
    public void atualizar(Fornece fornece) {
        String sql = "UPDATE _Fornece SET fk_Produto_NSM = ?, fk_Fornecedor_CNPJ = ?, data = ?, valor = ? WHERE id = ?";
        jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData(), fornece.getValor(), fornece.getId());
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
        List<Fornece> forneceList = jdbcTemplate.query(sql, new Object[]{id}, mapperFornece);
        if (forneceList.isEmpty()) {
            return null;
        }
        return forneceList.get(0);
    }

    @Override
    public boolean produtoExiste(int nsm) {
        String sql = "SELECT COUNT(*) FROM Produto WHERE NSM = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{nsm}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public boolean fornecedorExiste(String cnpj) {
        String sql = "SELECT COUNT(*) FROM Fornecedor WHERE CNPJ = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public boolean estoqueSuficiente(int nsm) {
        String sql = "SELECT qtd FROM Estoque WHERE produtoNsm = ?";
        Integer estoque = jdbcTemplate.queryForObject(sql, new Object[]{nsm}, Integer.class);
        return estoque != null && estoque > 0;
    }
}
