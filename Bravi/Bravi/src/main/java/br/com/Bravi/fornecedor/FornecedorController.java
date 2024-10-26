package br.com.Bravi.fornecedor;

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

    @PutMapping
    public ResponseEntity<String> atualizarFornecedor(@RequestBody Fornecedor fornecedor) {
        fornecedorService.atualizarFornecedor(fornecedor);
        return new ResponseEntity<>("Fornecedor atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{cnpj}")
    public ResponseEntity<String> removerFornecedor(@PathVariable String cnpj) {
        fornecedorService.removerFornecedor(cnpj);
        return new ResponseEntity<>("Fornecedor removido com sucesso!", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }

    @GetMapping("/{cnpj}")
    public ResponseEntity<Fornecedor> buscarFornecedorPorCNPJ(@PathVariable String cnpj) {
        Fornecedor fornecedor = fornecedorService.buscarFornecedorPorCNPJ(cnpj);
        return new ResponseEntity<>(fornecedor, HttpStatus.OK);
    }
}
