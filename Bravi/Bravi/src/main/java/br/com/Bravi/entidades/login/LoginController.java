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
            Login login = new Login(usuario, senha);
            String error = loginService.autenticar(login);

            if (error != null) {
                model.addAttribute("error", error);
                return "login";
            }

            return "redirect:/dashboard/";
        } catch (Exception e) {
            model.addAttribute("error", "Erro interno: " + e.getMessage());
            return "login";
        }
    }
}
