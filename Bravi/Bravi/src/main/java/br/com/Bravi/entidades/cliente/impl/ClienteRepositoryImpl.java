package br.com.Bravi.entidades.cliente.impl;

import br.com.Bravi.entidades.cliente.Cliente;
import br.com.Bravi.entidades.cliente.ClienteRepository;
import br.com.Bravi.entidades.cliente.mapper.MapperCliente;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperCliente clienteMapper;

    public ClienteRepositoryImpl(JdbcTemplate jdbcTemplate, MapperCliente clienteMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public void inserir(Cliente cliente) {
        String sql = "INSERT INTO Cliente (CNPJ, Nome, Rua, Bairro, CEP, Numero, Inscricao_Estadual, Razao_Social) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                cliente.getCnpj(),
                cliente.getNome(),
                cliente.getRua(),
                cliente.getBairro(),
                cliente.getCep(),
                cliente.getNumero(),
                cliente.getInscricaoEstadual(),
                cliente.getRazaoSocial());
    }

    @Override
    public void alterar(Cliente cliente) {
        String sql = "UPDATE Cliente SET Nome = ?, Rua = ?, Bairro = ?, CEP = ?, Numero = ?, Inscricao_Estadual = ?, Razao_Social = ? WHERE CNPJ = ?";
        jdbcTemplate.update(sql,
                cliente.getNome(),
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
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cnpj}, clienteMapper::mapRow);
        } catch (EmptyResultDataAccessException e) {
            throw new ClienteNaoEncontradoException("Cliente com CNPJ " + cnpj + " não encontrado: " + e.getMessage());
        }
    }
}
