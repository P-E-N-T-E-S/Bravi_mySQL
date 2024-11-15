package br.com.Bravi.entidades.fornece.impl;

import br.com.Bravi.entidades.fornece.Fornece;
import br.com.Bravi.entidades.fornece.ForneceRepository;
import br.com.Bravi.entidades.fornece.mapper.MapperFornece;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
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
        String sql = "INSERT INTO _Fornece (fk_Fornecedor_CNPJ, fk_Produto_NSM) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, fornece.getFornecedorCnpj(), fornece.getProdutoNsm());
        } catch (DataIntegrityViolationException e) {
            throw new FornecedorNaoEncontradoException("Fornecedor ou produto não encontrados.");
        }
    }

    @Override
    public void atualizar(Fornece fornece) {
        String sql = "UPDATE _Fornece SET fk_Fornecedor_CNPJ = ?, fk_Produto_NSM = ? WHERE id = ?";
        jdbcTemplate.update(sql, fornece.getFornecedorCnpj(), fornece.getProdutoNsm(), fornece.getId());
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM _Fornece WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected == 0) {
            throw new FornecedorNaoEncontradoException("Fornecedor com ID " + id + " não encontrado para exclusão.");
        }
    }

    @Override
    public List<Fornece> listar() {
        String sql = "SELECT * FROM _Fornece";
        return jdbcTemplate.query(sql, mapperFornece);
    }

    @Override
    public Fornece buscarPorId(int id) {
        String sql = "SELECT * FROM _Fornece WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{id}, mapperFornece);
        } catch (EmptyResultDataAccessException e) {
            throw new FornecedorNaoEncontradoException("Fornecedor com ID " + id + " não encontrado.");
        }
    }

    @Override
    public boolean fornecedorExiste(String cnpj) {
        String sql = "SELECT COUNT(*) FROM Fornecedor WHERE CNPJ = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, Integer.class);
        return count != null && count > 0;
    }
}
