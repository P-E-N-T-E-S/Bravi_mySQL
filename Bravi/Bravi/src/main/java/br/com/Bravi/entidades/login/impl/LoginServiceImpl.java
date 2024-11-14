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
    public String validarCredenciais(String usuario, String senha) {
        if (usuario == null || !usuario.matches("\\d{11}")) {
            return "O usuário deve conter exatamente 11 dígitos numéricos.";
        }
        if (senha == null || senha.isEmpty()) {
            return "A senha não pode estar vazia.";
        }
        return null;
    }

    @Override
    public String autenticar(Login login) {
        String erroValidacao = validarCredenciais(login.getUsuario(), login.getSenha());
        if (erroValidacao != null) {
            return erroValidacao;
        }

        Login usuarioNoBanco = loginRepository.buscarPorUsuario(login.getUsuario());
        if (usuarioNoBanco == null || !usuarioNoBanco.getSenha().equals(login.getSenha())) {
            return "Credenciais inválidas.";
        }

        return null;
    }
}
