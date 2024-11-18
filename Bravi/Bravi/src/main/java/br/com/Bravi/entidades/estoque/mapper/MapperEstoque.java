package br.com.Bravi.entidades.estoque.mapper;

import br.com.Bravi.entidades.estoque.Estoque;
import br.com.Bravi.entidades.setor.Setor;
import br.com.Bravi.entidades.categoria.Categoria;  // A classe Categoria precisa existir
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperEstoque implements RowMapper<Estoque> {

    @Override
    public Estoque mapRow(ResultSet rs, int rowNum) throws SQLException {
        Setor setor = new Setor(rs.getInt("fk_Setor_id"), rs.getString("setor_nome"));
        Categoria categoria = new Categoria(rs.getInt("categoria_id"), rs.getString("categoria_nome"));

        Estoque estoque = new Estoque();
        estoque.setSetor(setor);
        estoque.setQtd(rs.getInt("qtd"));
        estoque.setProdutoNsm(rs.getInt("fk_Produto_NSM"));
        estoque.setCategoria(categoria);  // Atribuindo Categoria
        return estoque;
    }

    public Object[] mapEstoqueToParams(Estoque estoque) {
        return new Object[]{
                estoque.getSetor().getId(),
                estoque.getQtd(),
                estoque.getProdutoNsm(),
                estoque.getCategoria().getId()
        };
    }
}
