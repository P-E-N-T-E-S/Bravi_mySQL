package br.com.Bravi.entidades.funcionario.mapper;

import br.com.Bravi.entidades.funcionario.Funcionario;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeadorFuncionario implements RowMapper <Funcionario> {

    @Override
    public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
        String setor = rs.getString("Setor");
        String cargo = rs.getString("Cargo");
        String cpf = rs.getString("CPF");
        String nome = rs.getString("Nome");
        Date dataDeNascimento = rs.getDate("Data_de_Nascimento");
        String rua = rs.getString("Rua");
        String bairro = rs.getString("Bairro");
        int cep = rs.getInt("CEP");
        int numero = rs.getInt("Numero");
        String cpfGerente = rs.getString("CPF_GERENTE");

        return new Funcionario(setor, cargo, cpf, nome, dataDeNascimento, rua, bairro, cep, numero, cpfGerente);
    }
}
