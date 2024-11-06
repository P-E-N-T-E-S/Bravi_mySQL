package br.com.Bravi.produto.mapper;

import br.com.Bravi.produto.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProduto implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Produto produto = new Produto();
        produto.setNsm(rs.getInt("NSM"));
        produto.setNome(rs.getString("Nome"));
        produto.setDescricao(rs.getString("Descrição"));
        return produto;
    }
}