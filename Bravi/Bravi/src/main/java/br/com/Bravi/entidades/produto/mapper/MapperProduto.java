package br.com.Bravi.entidades.produto.mapper;

import br.com.Bravi.entidades.categoria.Categoria;
import br.com.Bravi.entidades.produto.Produto;
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

        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("fk_Categoria_id"));
        categoria.setNome(rs.getString("categoria_nome"));
        produto.setCategoria(categoria);

        return produto;
    }
}