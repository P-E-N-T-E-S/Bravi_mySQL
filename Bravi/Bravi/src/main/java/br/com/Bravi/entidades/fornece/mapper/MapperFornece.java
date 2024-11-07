package br.com.Bravi.entidades.fornece.mapper;

import br.com.Bravi.entidades.fornece.Fornece;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;  // Add this import

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperFornece implements RowMapper<Fornece> {
    @Override
    public Fornece mapRow(ResultSet rs, int rowNum) throws SQLException {
        Fornece fornece = new Fornece();
        fornece.setId(rs.getInt("id"));
        fornece.setProdutoNsm(rs.getInt("fk_Produto_NSM"));
        fornece.setFornecedorCnpj(rs.getString("fk_Fornecedor_CNPJ"));
        fornece.setData(rs.getDate("data"));
        return fornece;
    }
}
