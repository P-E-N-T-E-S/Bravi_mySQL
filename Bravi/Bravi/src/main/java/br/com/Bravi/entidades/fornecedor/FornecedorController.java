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
        fornecedorService.adicionarFornecedor(fornecedor);
        return new ResponseEntity<>("Fornecedor adicionado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/{cnpj}")
    public ResponseEntity<String> atualizarFornecedor(@PathVariable String cnpj, @RequestBody Fornecedor fornecedor) {
        try {
            fornecedor.setCnpj(cnpj);
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
    public ResponseEntity<Object> buscarFornecedorPorCNPJ(@PathVariable String cnpj) {
        try {
            Fornecedor fornecedor = fornecedorService.buscarFornecedorPorCNPJ(cnpj);
            return new ResponseEntity<>(fornecedor, HttpStatus.OK);
        } catch (FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }
}
