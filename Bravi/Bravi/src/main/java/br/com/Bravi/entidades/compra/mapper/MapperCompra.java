package br.com.Bravi.entidades.compra.mapper;

import br.com.Bravi.entidades.compra.Compra;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperCompra implements RowMapper<Compra> {

    @Override
    public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
        Compra compra = new Compra();
        compra.setId(rs.getInt("id"));
        compra.setProdutoNsm(rs.getInt("fk_Produto_NSM"));
        compra.setClienteCnpj(rs.getString("fk_Cliente_CNPJ"));
        compra.setValor(rs.getDouble("valor"));
        return compra;
    }
}
