package br.com.Bravi.estoque.mapper;

import br.com.Bravi.estoque.Estoque;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperEstoque {

    public Estoque mapRowToEstoque(ResultSet rs) throws SQLException {
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
