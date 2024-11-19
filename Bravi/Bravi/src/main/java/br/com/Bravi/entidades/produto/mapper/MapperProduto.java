package br.com.Bravi.entidades.produto.mapper;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.produto.Produto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperProduto implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet rs, int rowNum) throws SQLException {
        int nsm = (rs.getInt("NSM"));
        String nome = (rs.getString("Nome"));
        String descricao = (rs.getString("Descrição"));
        Produto produto = new Produto(nsm, nome, descricao, null);

        return produto;
    }
}