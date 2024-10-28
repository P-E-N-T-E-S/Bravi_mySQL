package br.com.Bravi.estoque.mapper;

import br.com.Bravi.estoque.Estoque;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperEstoque implements RowMapper<Estoque> {

    @Override
    public Estoque mapRow(ResultSet rs, int rowNum) throws SQLException {
        Estoque estoque = new Estoque();
        estoque.setSetor(rs.getInt("setor"));
        estoque.setQtd(rs.getInt("qtd"));
        estoque.setProdutoNsm(rs.getInt("fk_Produto_NSM"));
        return estoque;
    }

    public Object[] mapEstoqueToParams(Estoque estoque) {
        return new Object[]{
                estoque.getSetor(),
                estoque.getQtd(),
                estoque.getProdutoNsm()
        };
    }
}
