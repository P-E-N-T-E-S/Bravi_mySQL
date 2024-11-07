package br.com.Bravi.entidades.funcionario;

import br.com.Bravi.exceptions.CampoDeAlteracaoNaoEncontradoException;
import br.com.Bravi.exceptions.FiltroNaoDisponivelException;
import br.com.Bravi.exceptions.FuncionarioNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<String> novoFuncionario(@RequestBody Funcionario funcionario) {
        funcionarioService.inserir(funcionario);
        return new ResponseEntity<>("Funcionário salvo com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return new ResponseEntity<>(funcionarioService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{filtro}")
    public ResponseEntity<Object> buscarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor) {
        try {
            Funcionario funcionario = buscarFuncionarioPorFiltro(filtro, valor);
            return new ResponseEntity<>(funcionario, HttpStatus.OK);
        } catch (FuncionarioNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Funcionário não encontrado com o filtro: " + filtro);
        } catch (FiltroNaoDisponivelException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Filtro " + e.getMessage() + " não disponível");
        }
    }

    @DeleteMapping("/{filtro}")
    public ResponseEntity<String> deletarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor) {
        try {
            Funcionario funcionario = buscarFuncionarioPorFiltro(filtro, valor);
            funcionarioService.excluir(funcionario);
            return new ResponseEntity<>("Funcionário deletado com sucesso!", HttpStatus.OK);
        } catch (FuncionarioNaoEncontradoException e) {
            return new ResponseEntity<>("Funcionário não encontrado com o filtro: " + filtro, HttpStatus.NOT_FOUND);
        } catch (FiltroNaoDisponivelException e) {
            return new ResponseEntity<>("Filtro não disponível", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{filtro}")
    public ResponseEntity<String> atualizarFuncionarioFiltro(@PathVariable String filtro, @RequestParam String valor, @RequestBody Funcionario funcionario) {
        try {
            Funcionario funcionarioExistente = buscarFuncionarioPorFiltro(filtro, valor);
            funcionario.setCpf(funcionarioExistente.getCpf());
            funcionarioService.alterar(funcionario);
            return new ResponseEntity<>("Funcionário atualizado com sucesso!", HttpStatus.OK);
        } catch (FuncionarioNaoEncontradoException e) {
            return new ResponseEntity<>("Funcionário não encontrado com o filtro: " + filtro, HttpStatus.NOT_FOUND);
        } catch (FiltroNaoDisponivelException e) {
            return new ResponseEntity<>("Filtro não disponível", HttpStatus.BAD_REQUEST);
        } catch (CampoDeAlteracaoNaoEncontradoException e) {
            return new ResponseEntity<>("Campo para alteração: " + e.getMessage() + " indisponível", HttpStatus.BAD_REQUEST);
        }
    }

    private Funcionario buscarFuncionarioPorFiltro(String filtro, String valor) throws FiltroNaoDisponivelException {
        switch (filtro.toLowerCase()) {
            case "cpf":
                return funcionarioService.buscarPorCPF(valor);
            case "setor":
                return funcionarioService.buscarPorSetor(valor);
            case "nome":
                return funcionarioService.buscarPorNome(valor);
            case "cargo":
                return funcionarioService.buscarPorCargo(valor);
            default:
                throw new FiltroNaoDisponivelException(filtro);
        }
    }
}
