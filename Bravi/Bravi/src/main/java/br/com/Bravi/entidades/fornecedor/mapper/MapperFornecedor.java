package br.com.Bravi.entidades.fornecedor.mapper;

import br.com.Bravi.entidades.fornecedor.Fornecedor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperFornecedor implements RowMapper<Fornecedor> {

    @Override
    public Fornecedor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setCategoria(rs.getString("categoria"));
        fornecedor.setCnpj(rs.getString("CNPJ"));
        fornecedor.setRua(rs.getString("Rua"));
        fornecedor.setBairro(rs.getString("Bairro"));
        fornecedor.setCep(rs.getString("CEP"));
        fornecedor.setNumero(rs.getInt("Numero"));
        fornecedor.setInscricaoEstadual(rs.getString("Inscricao_Estadual"));
        fornecedor.setRazaoSocial(rs.getString("Razao_Social"));
        return fornecedor;
    }
}
