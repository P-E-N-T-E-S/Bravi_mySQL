package br.com.Bravi.entidades.fornece.impl;

import br.com.Bravi.entidades.fornece.Fornece;
import br.com.Bravi.entidades.fornece.ForneceRepository;
import br.com.Bravi.entidades.fornece.mapper.MapperFornece;
import br.com.Bravi.exceptions.ForneceNaoEncontradoException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
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
        if (!produtoExiste(fornece.getProdutoNsm())) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado para o NSM: " + fornece.getProdutoNsm());
        }
        if (!fornecedorExiste(fornece.getFornecedorCnpj())) {
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado para o CNPJ: " + fornece.getFornecedorCnpj());
        }
        jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData());
    }

    @Override
    public void atualizar(Fornece fornece) {
        String sql = "UPDATE _Fornece SET fk_Produto_NSM = ?, fk_Fornecedor_CNPJ = ?, data = ? WHERE id = ?";
        if (!produtoExiste(fornece.getProdutoNsm())) {
            throw new ProdutoNaoEncontradoException("Produto não encontrado para o NSM: " + fornece.getProdutoNsm());
        }
        if (!fornecedorExiste(fornece.getFornecedorCnpj())) {
            throw new FornecedorNaoEncontradoException("Fornecedor não encontrado para o CNPJ: " + fornece.getFornecedorCnpj());
        }
        int rowsAffected = jdbcTemplate.update(sql, fornece.getProdutoNsm(), fornece.getFornecedorCnpj(), fornece.getData(), fornece.getId());
        if (rowsAffected == 0) {
            throw new ForneceNaoEncontradoException("Fornece com ID " + fornece.getId() + " não encontrado.");
        }
    }

    @Override
    public void excluir(int id) {
        String sql = "DELETE FROM _Fornece WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        if (rowsAffected == 0) {
            throw new ForneceNaoEncontradoException("Fornece com ID " + id + " não encontrado.");
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
        List<Fornece> forneceList = jdbcTemplate.query(sql, new Object[]{id}, mapperFornece);
        if (forneceList.isEmpty()) {
            throw new ForneceNaoEncontradoException("Fornece com ID " + id + " não encontrado.");
        }
        return forneceList.get(0);
    }

    private boolean produtoExiste(int nsm) {
        String sql = "SELECT COUNT(*) FROM Produto WHERE NSM = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{nsm}, Integer.class);
        return count != null && count > 0;
    }

    private boolean fornecedorExiste(String cnpj) {
        String sql = "SELECT COUNT(*) FROM Fornecedor WHERE CNPJ = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, Integer.class);
        return count != null && count > 0;
    }
}
