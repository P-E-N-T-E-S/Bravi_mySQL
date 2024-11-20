package br.com.Bravi.entidades.funcionario;

import br.com.Bravi.entidades.setor.Setor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<String> novoFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioService.inserir(funcionario);
            return new ResponseEntity<>("Funcionário salvo com sucesso!", HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<?>  listarFuncionarios() {
        List<Funcionario> funcionarios = funcionarioService.listar();
        return ResponseEntity.ok(funcionarios);
    }

    @GetMapping
    public String listarFuncionarios(Model model) {
        List<Funcionario> funcionarios = funcionarioService.listar();
        model.addAttribute("funcionarios", funcionarios);
        return "funcionarios";
    }

    @GetMapping("/{filtro}")
    public ResponseEntity<Object> buscarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor) {
        try {
            Funcionario funcionario = null;
            switch (filtro) {
                case "cpf":
                    funcionario = funcionarioService.buscarPorCPF(valor);
                    break;
                case "setor":
                    funcionario = funcionarioService.buscarPorSetor(new Setor(Integer.parseInt(valor), valor));
                    break;
                case "nome":
                    funcionario = funcionarioService.buscarPorNome(valor);
                    break;
                case "cargo":
                    funcionario = funcionarioService.buscarPorCargo(valor);
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Filtro não válido.");
            }
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{filtro}")
    public ResponseEntity<String> deletarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor) {
        try {
            Funcionario funcionario = null;
            switch (filtro) {
                case "cpf":
                    funcionario = funcionarioService.buscarPorCPF(valor);
                    break;
                case "setor":
                    funcionario = funcionarioService.buscarPorSetor(new Setor(Integer.parseInt(valor), valor));
                    break;
                case "nome":
                    funcionario = funcionarioService.buscarPorNome(valor);
                    break;
                case "cargo":
                    funcionario = funcionarioService.buscarPorCargo(valor);
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Filtro não válido.");
            }
            funcionarioService.excluir(funcionario);
            return new ResponseEntity<>("Funcionário deletado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PutMapping("/{filtro}")
    public ResponseEntity<String> alterarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor, @RequestBody Funcionario funcionario) {
        try {
            Funcionario funcionarioExistente = null;
            switch (filtro) {
                case "cpf":
                    funcionarioExistente = funcionarioService.buscarPorCPF(valor);
                    break;
                case "setor":
                    funcionarioExistente = funcionarioService.buscarPorSetor(new Setor(Integer.parseInt(valor), valor));
                    break;
                case "nome":
                    funcionarioExistente = funcionarioService.buscarPorNome(valor);
                    break;
                case "cargo":
                    funcionarioExistente = funcionarioService.buscarPorCargo(valor);
                    break;
                default:
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Filtro não válido.");
            }
            if (funcionarioExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado.");
            }
            funcionarioService.alterar(funcionario, filtro, valor);
            return new ResponseEntity<>("Funcionário alterado com sucesso!", HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
