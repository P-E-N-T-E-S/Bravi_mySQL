package br.com.Bravi.cliente.impl;

import br.com.Bravi.cliente.Cliente;
import br.com.Bravi.cliente.ClienteRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import br.com.Bravi.cliente.mapper.MapperCliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperCliente clienteMapper;

    public ClienteRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.clienteMapper = new MapperCliente();
    }

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CNPJ, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getCnpj(),
                cliente.getRua(),
                cliente.getBairro(),
                cliente.getCep(),
                cliente.getNumero(),
                cliente.getInscricaoEstadual(),
                cliente.getRazaoSocial());
    }

    @Override
    public void alterar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Rua = ?, Bairro = ?, CEP = ?, Numero = ?, Inscricao_Estadual = ?, Razao_Social = ? WHERE CNPJ = ?";
        jdbcTemplate.update(sql,
                cliente.getRua(),
                cliente.getBairro(),
                cliente.getCep(),
                cliente.getNumero(),
                cliente.getInscricaoEstadual(),
                cliente.getRazaoSocial(),
                cliente.getCnpj());
    }

    @Override
    public void excluir(String cnpj) {
        String sql = "DELETE FROM Cliente WHERE CNPJ = ?";
        jdbcTemplate.update(sql, cnpj);
    }

    @Override
    public List<Cliente> listar() {
        String sql = "SELECT * FROM Cliente";
        return jdbcTemplate.query(sql, clienteMapper::mapRow);
    }

    @Override
    public Cliente buscarPorCNPJ(String cnpj) {
        String sql = "SELECT * FROM Cliente WHERE CNPJ = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, clienteMapper::mapRow);
    }
}
