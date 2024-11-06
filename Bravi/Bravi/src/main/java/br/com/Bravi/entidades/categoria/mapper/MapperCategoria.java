package br.com.Bravi.entidades.categoria.mapper;

import br.com.Bravi.entidades.categoria.Categoria;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapperCategoria implements RowMapper<Categoria> {

    @Override
    public Categoria mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categoria categoria = new Categoria();
        categoria.setId(rs.getInt("id"));
        categoria.setNome(rs.getString("nome"));
        return categoria;
    }
}
