package br.com.Bravi.entidades.cliente;

import br.com.Bravi.entidades.cliente.impl.ClienteServiceImpl;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    private final ClienteServiceImpl clienteService;

    public ClienteController(ClienteServiceImpl clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<String> inserirCliente(@RequestBody Cliente cliente) {
        clienteService.inserir(cliente);
        return new ResponseEntity<>("Cliente inserido com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<String> alterarCliente(@PathVariable String cnpj, @RequestBody Cliente cliente) {
        cliente.setCnpj(cnpj);
        try {
            clienteService.alterar(cliente);
            return new ResponseEntity<>("Cliente alterado com sucesso!", HttpStatus.OK);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> excluirCliente(@PathVariable String cnpj) {
        try {
            clienteService.excluir(cnpj);
            return new ResponseEntity<>("Cliente excluído com sucesso!", HttpStatus.OK);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listar();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<?> buscarClientePorCNPJ(@PathVariable String cnpj) {
        try {
            Cliente cliente = clienteService.buscarPorCNPJ(cnpj);
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } catch (ClienteNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
