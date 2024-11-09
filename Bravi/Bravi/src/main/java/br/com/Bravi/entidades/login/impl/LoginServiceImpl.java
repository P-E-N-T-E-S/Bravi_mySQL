package br.com.Bravi.entidades.login.impl;

import br.com.Bravi.entidades.login.Login;
import br.com.Bravi.entidades.login.LoginRepository;
import br.com.Bravi.entidades.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public boolean autenticar(Login login) {
        Login usuarioNoBanco = loginRepository.buscarPorUsuario(login.getUsuario());

        return usuarioNoBanco != null && usuarioNoBanco.getSenha().equals(login.getSenha());
    }
}
