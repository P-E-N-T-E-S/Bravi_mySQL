package br.com.Bravi.entidades.funcionario.mapper;

import br.com.Bravi.entidades.funcionario.Funcionario;

import br.com.Bravi.entidades.setor.Setor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MapeadorFuncionario implements RowMapper<Funcionario> {

    @Override
    public Funcionario mapRow(ResultSet rs, int rowNum) throws SQLException {
        int setorId = rs.getInt("fk_Setor_id");
        String cargo = rs.getString("Cargo");
        String cpf = rs.getString("CPF");
        String nome = rs.getString("Nome");
        Date dataDeNascimento = rs.getDate("Data_de_Nascimento");
        String rua = rs.getString("Rua");
        String bairro = rs.getString("Bairro");
        String cep = rs.getString("CEP");
        String numero = rs.getString("Numero");
        String cpfGerente = rs.getString("CPF_GERENTE");
        Setor setor = new Setor(setorId);

        return new Funcionario(setor, cargo, cpf, nome, dataDeNascimento, rua, bairro, cep, numero, cpfGerente);
    }
}
