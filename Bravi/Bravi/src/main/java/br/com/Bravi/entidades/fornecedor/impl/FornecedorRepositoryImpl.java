package br.com.Bravi.entidades.fornecedor.impl;

import br.com.Bravi.entidades.fornecedor.Fornecedor;
import br.com.Bravi.entidades.fornecedor.FornecedorRepository;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepository {

    private final JdbcTemplate jdbcTemplate;

    public FornecedorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private boolean cnpjExiste(String cnpj) {
        String sql = "SELECT COUNT(*) FROM Fornecedor WHERE CNPJ = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, Integer.class);
        return count != null && count > 0;
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        if (cnpjExiste(fornecedor.getCnpj())) {
            throw new RuntimeException("Fornecedor com o CNPJ " + fornecedor.getCnpj() + " já existe.");
        }
        String sql = "INSERT INTO Fornecedor (categoria, CNPJ, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, fornecedor.getCategoria(), fornecedor.getCnpj(), fornecedor.getRua(),
                fornecedor.getBairro(), fornecedor.getCep(), fornecedor.getNumero(),
                fornecedor.getInscricaoEstadual(), fornecedor.getRazaoSocial());
    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        if (!cnpjExiste(fornecedor.getCnpj())) {
            throw new FornecedorNaoEncontradoException("Fornecedor com CNPJ " + fornecedor.getCnpj() + " não encontrado.");
        }
        String sql = "UPDATE Fornecedor SET categoria = ?, Rua = ?, Bairro = ?, CEP = ?, Numero = ?, Inscricao_Estadual = ?, Razao_Social = ? WHERE CNPJ = ?";
        jdbcTemplate.update(sql, fornecedor.getCategoria(), fornecedor.getRua(), fornecedor.getBairro(),
                fornecedor.getCep(), fornecedor.getNumero(), fornecedor.getInscricaoEstadual(),
                fornecedor.getRazaoSocial(), fornecedor.getCnpj());
    }

    @Override
    public void excluir(String cnpj) {
        if (!cnpjExiste(cnpj)) {
            throw new FornecedorNaoEncontradoException("Fornecedor com CNPJ " + cnpj + " não encontrado.");
        }
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";
        jdbcTemplate.update(sql, cnpj);
    }

    @Override
    public Fornecedor buscarPorCNPJ(String cnpj) {
        if (!cnpjExiste(cnpj)) {
            throw new FornecedorNaoEncontradoException("Fornecedor com CNPJ " + cnpj + " não encontrado.");
        }
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, (rs, rowNum) -> new Fornecedor(
                rs.getString("categoria"), rs.getString("CNPJ"), rs.getString("Rua"),
                rs.getString("Bairro"), rs.getString("CEP"), rs.getInt("Numero"),
                rs.getString("Inscricao_Estadual"), rs.getString("Razao_Social")));
    }

    @Override
    public List<Fornecedor> listar() {
        String sql = "SELECT * FROM Fornecedor";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Fornecedor(
                rs.getString("categoria"),
                rs.getString("CNPJ"),
                rs.getString("Rua"),
                rs.getString("Bairro"),
                rs.getString("CEP"),
                rs.getInt("Numero"),
                rs.getString("Inscricao_Estadual"),
                rs.getString("Razao_Social")
        ));
    }
}
