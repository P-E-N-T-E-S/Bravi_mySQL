package br.com.Bravi.entidades.login.impl;

import br.com.Bravi.entidades.login.Login;
import br.com.Bravi.entidades.login.LoginRepository;
import br.com.Bravi.entidades.login.mapper.MapperLogin;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginRepositoryImpl implements LoginRepository {

    private final JdbcTemplate jdbcTemplate;
    private final MapperLogin loginMapper;

    public LoginRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.loginMapper = new MapperLogin();
    }

    @Override
    public Login buscarPorUsuario(String usuario) {
        String sql = "SELECT usuario, senha FROM Usuario WHERE usuario = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{usuario}, loginMapper);
    }
}
