package br.com.Bravi.entidades.cliente.mapper;

import br.com.Bravi.entidades.cliente.Cliente;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperCliente implements RowMapper<Cliente> {
    @Override
    public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
        String cnpj = rs.getString("CNPJ");
        String nome = rs.getString("Nome");
        String rua = rs.getString("Rua");
        String bairro = rs.getString("Bairro");
        String cep = rs.getString("CEP");
        String numero = rs.getString("Numero");
        String numero2 = rs.getString("Numero2");
        String inscricaoEstadual = rs.getString("Inscricao_Estadual");
        String razaoSocial = rs.getString("Razao_Social");

        return new Cliente(cnpj, nome, rua, bairro, cep, numero, numero2, inscricaoEstadual, razaoSocial);
    }
}
