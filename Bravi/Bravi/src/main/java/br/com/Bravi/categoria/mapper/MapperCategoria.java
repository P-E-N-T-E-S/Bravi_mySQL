package br.com.Bravi.categoria.mapper;

import br.com.Bravi.categoria.Categoria;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperCategoria {

    public Categoria mapRow(ResultSet rs) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id"));
        categoria.setNome(rs.getString("nome"));
        return categoria;
    }
}
