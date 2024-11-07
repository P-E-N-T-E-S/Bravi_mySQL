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
        String rua = rs.getString("Rua");
        String bairro = rs.getString("Bairro");
        int cep = rs.getInt("CEP");
        int numero = rs.getInt("Numero");
        int inscricaoEstadual = rs.getInt("Inscricao_Estadual");
        String razaoSocial = rs.getString("Razao_Social");

        return new Cliente(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
    }
}