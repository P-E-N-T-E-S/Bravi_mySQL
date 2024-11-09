package br.com.Bravi.entidades.login.mapper;

import br.com.Bravi.entidades.login.Login;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapperLogin implements RowMapper<Login> {

    @Override
    public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
        Login login = new Login();
        login.setUsuario(rs.getString("usuario"));
        login.setSenha(rs.getString("senha"));
        return login;
    }
}
