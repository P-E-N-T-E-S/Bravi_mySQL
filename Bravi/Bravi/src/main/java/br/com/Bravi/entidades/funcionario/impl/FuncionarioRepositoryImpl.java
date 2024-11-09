package br.com.Bravi.entidades.funcionario.impl;

import br.com.Bravi.entidades.funcionario.Funcionario;
import br.com.Bravi.entidades.funcionario.FuncionarioRepository;
import br.com.Bravi.entidades.funcionario.mapper.MapeadorFuncionario;
import br.com.Bravi.exceptions.FuncionarioNaoEncontradoException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapeadorFuncionario funcionarioMapper;

    public FuncionarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.funcionarioMapper = new MapeadorFuncionario();
    }

    @Override
    public void inserir(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario (Setor, Cargo, CPF, Nome, Data_de_Nascimento, Rua, Bairro, CEP, Numero, CPF_GERENTE) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                funcionario.getSetor(),
                funcionario.getCargo(),
                funcionario.getCpf(),
                funcionario.getNome(),
                funcionario.getDataDeNascimento(),
                funcionario.getRua(),
                funcionario.getBairro(),
                funcionario.getCep(),
                funcionario.getNumero(),
                funcionario.getCpfGerente());
    }

    @Override
    public void alterar(Funcionario funcionario) {
        String sql = "UPDATE funcionario SET Setor = ?, Cargo = ?, Nome = ?, Data_de_Nascimento = ?, Rua = ?, Bairro = ?, CEP = ?, Numero = ?, CPF_GERENTE = ? WHERE CPF = ?";
        int rowsAffected = jdbcTemplate.update(sql,
                funcionario.getSetor(),
                funcionario.getCargo(),
                funcionario.getNome(),
                funcionario.getDataDeNascimento(),
                funcionario.getRua(),
                funcionario.getBairro(),
                funcionario.getCep(),
                funcionario.getNumero(),
                funcionario.getCpfGerente(),
                funcionario.getCpf());

        if (rowsAffected == 0) {
            throw new FuncionarioNaoEncontradoException("Funcionário com CPF " + funcionario.getCpf() + " não encontrado.");
        }
    }

    @Override
    public void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE CPF = ?";
        int rowsAffected = jdbcTemplate.update(sql, funcionario.getCpf());

        if (rowsAffected == 0) {
            throw new FuncionarioNaoEncontradoException("Funcionário com CPF " + funcionario.getCpf() + " não encontrado.");
        }
    }

    @Override
    public List<Funcionario> listar() {
        String sql = "SELECT * FROM funcionario";
        return jdbcTemplate.query(sql, funcionarioMapper::mapRow);
    }

    @Override
    public Funcionario buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE CPF = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cpf}, funcionarioMapper::mapRow);
        } catch (EmptyResultDataAccessException e) {
            throw new FuncionarioNaoEncontradoException("Funcionário com CPF " + cpf + " não encontrado.");
        }
    }

    @Override
    public Funcionario buscarPorSetor(String setor) {
        String sql = "SELECT * FROM funcionario WHERE Setor = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{setor}, funcionarioMapper::mapRow);
        } catch (EmptyResultDataAccessException e) {
            throw new FuncionarioNaoEncontradoException("Nenhum funcionário encontrado no setor " + setor + ".");
        }
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        String sql = "SELECT * FROM funcionario WHERE Nome = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{nome}, funcionarioMapper::mapRow);
        } catch (EmptyResultDataAccessException e) {
            throw new FuncionarioNaoEncontradoException("Funcionário com nome " + nome + " não encontrado.");
        }
    }

    @Override
    public Funcionario buscarPorCargo(String cargo) {
        String sql = "SELECT * FROM funcionario WHERE Cargo = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{cargo}, funcionarioMapper::mapRow);
        } catch (EmptyResultDataAccessException e) {
            throw new FuncionarioNaoEncontradoException("Nenhum funcionário encontrado com o cargo " + cargo + ".");
        }
    }
}
