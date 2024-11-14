package br.com.Bravi.entidades.login;

public interface LoginService {
    String autenticar(Login login);
    String validarCredenciais(String usuario, String senha);
}
