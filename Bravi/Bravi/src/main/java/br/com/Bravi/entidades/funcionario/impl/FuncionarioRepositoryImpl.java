package br.com.Bravi.entidades.funcionario.impl;

import br.com.Bravi.entidades.funcionario.Funcionario;
import br.com.Bravi.entidades.funcionario.FuncionarioRepository;
import br.com.Bravi.entidades.funcionario.mapper.MapeadorFuncionario;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FuncionarioRepositoryImpl implements FuncionarioRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapeadorFuncionario funcionarioMapper;

    public FuncionarioRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.funcionarioMapper = new MapeadorFuncionario(); // Inicializando o mapper
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
        jdbcTemplate.update(sql,
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
    }

    @Override
    public void excluir(Funcionario funcionario) {
        String sql = "DELETE FROM funcionario WHERE CPF = ?";
        jdbcTemplate.update(sql, funcionario.getCpf());
    }

    @Override
    public List<Funcionario> listar() {
        String sql = "SELECT * FROM funcionario";
        return jdbcTemplate.query(sql, funcionarioMapper::mapRow);
    }

    @Override
    public Funcionario buscarPorCPF(String cpf) {
        String sql = "SELECT * FROM funcionario WHERE CPF = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cpf}, funcionarioMapper::mapRow);
    }

    @Override
    public Funcionario buscarPorSetor(String setor) {
        String sql = "SELECT * FROM funcionario WHERE Setor = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{setor}, funcionarioMapper::mapRow);
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        String sql = "SELECT * FROM funcionario WHERE Nome = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{nome}, funcionarioMapper::mapRow);
    }

    @Override
    public Funcionario buscarPorCargo(String cargo) {
        String sql = "SELECT * FROM funcionario WHERE Cargo = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{cargo}, funcionarioMapper::mapRow);
    }
}
