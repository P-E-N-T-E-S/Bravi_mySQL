package br.com.Bravi.entidades.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Login login) {
        if (login.getUsuario() == null || !login.getUsuario().matches("\\d{11}")) {
            return ResponseEntity.badRequest().body("Erro: O usuário (CPF) deve conter exatamente 11 dígitos numéricos.");
        }

        if (login.getSenha() == null || login.getSenha().isEmpty()) {
            return ResponseEntity.badRequest().body("Erro: A senha (nome) não pode estar vazia.");
        }

        if (loginService.autenticar(login)) {
            return ResponseEntity.ok("Login bem-sucedido!");
        } else {
            return ResponseEntity.status(401).body("Erro: Credenciais inválidas.");
        }
    }
}
