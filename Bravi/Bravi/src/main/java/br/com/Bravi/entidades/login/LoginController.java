package br.com.Bravi.entidades.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("usuario") String usuario, @RequestParam("senha") String senha, Model model) {
        try {
            if (usuario == null || !usuario.matches("\\d{11}")) {
                model.addAttribute("error", "O usuário deve conter exatamente 11 dígitos numéricos.");
                return "login";
            }

            if (senha == null || senha.isEmpty()) {
                model.addAttribute("error", "A senha não pode estar vazia.");
                return "login";
            }

            Login login = new Login(usuario, senha);
            if (loginService.autenticar(login)) {
                return "layout";
            } else {
                model.addAttribute("error", "Credenciais inválidas.");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", "Erro interno: " + e.getMessage());
            return "login";
        }
    }
}
