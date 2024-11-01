package br.com.Bravi.entidades.fornecedor.impl;

import br.com.Bravi.entidades.fornecedor.Fornecedor;
import br.com.Bravi.entidades.fornecedor.FornecedorRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FornecedorRepositoryImpl implements FornecedorRepository {

    private final JdbcTemplate jdbcTemplate;

    public FornecedorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void inserir(Fornecedor fornecedor) {
        String sql = "INSERT INTO Fornecedor (categoria, CNPJ, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                fornecedor.getCategoria(),
                fornecedor.getCnpj(),
                fornecedor.getRua(),
                fornecedor.getBairro(),
                fornecedor.getCep(),
                fornecedor.getNumero(),
                fornecedor.getInscricaoEstadual(),
                fornecedor.getRazaoSocial());
    }

    @Override
    public void alterar(Fornecedor fornecedor) {
        String sql = "UPDATE Fornecedor SET categoria = ?, Rua = ?, Bairro = ?, CEP = ?, Numero = ?, Inscricao_Estadual = ?, Razao_Social = ? WHERE CNPJ = ?";
        jdbcTemplate.update(sql,
                fornecedor.getCategoria(),
                fornecedor.getRua(),
                fornecedor.getBairro(),
                fornecedor.getCep(),
                fornecedor.getNumero(),
                fornecedor.getInscricaoEstadual(),
                fornecedor.getRazaoSocial(),
                fornecedor.getCnpj());
    }

    @Override
    public void excluir(String cnpj) {
        String sql = "DELETE FROM Fornecedor WHERE CNPJ = ?";
        jdbcTemplate.update(sql, cnpj);
    }

    @Override
    public List<Fornecedor> listar() {
        String sql = "SELECT * FROM Fornecedor";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Fornecedor(
                rs.getString("categoria"),
                rs.getString("CNPJ"),
                rs.getString("Rua"),
                rs.getString("Bairro"),
                rs.getInt("CEP"),
                rs.getInt("Numero"),
                rs.getInt("Inscricao_Estadual"),
                rs.getString("Razao_Social")
        ));
    }

    @Override
    public Fornecedor buscarPorCNPJ(String cnpj) {
        String sql = "SELECT * FROM Fornecedor WHERE CNPJ = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, (rs, rowNum) -> new Fornecedor(
                rs.getString("categoria"),
                rs.getString("CNPJ"),
                rs.getString("Rua"),
                rs.getString("Bairro"),
                rs.getInt("CEP"),
                rs.getInt("Numero"),
                rs.getInt("Inscricao_Estadual"),
                rs.getString("Razao_Social")
        ));
    }
}
