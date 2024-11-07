package br.com.Bravi.entidades.fornecedor;

import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarFornecedor(@RequestBody Fornecedor fornecedor) {
        try {
            fornecedorService.adicionarFornecedor(fornecedor);
            return new ResponseEntity<>("Fornecedor adicionado com sucesso!", HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarFornecedor(@RequestBody Fornecedor fornecedor) {
        try {
            fornecedorService.atualizarFornecedor(fornecedor);
            return new ResponseEntity<>("Fornecedor atualizado com sucesso!", HttpStatus.OK);
        } catch (FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> removerFornecedor(@PathVariable String cnpj) {
        try {
            fornecedorService.removerFornecedor(cnpj);
            return new ResponseEntity<>("Fornecedor removido com sucesso!", HttpStatus.OK);
        } catch (FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorCNPJ(@PathVariable String cnpj) {
        try {
            Fornecedor fornecedor = fornecedorService.buscarFornecedorPorCNPJ(cnpj);
            return new ResponseEntity<>(fornecedor, HttpStatus.OK);
        } catch (FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
