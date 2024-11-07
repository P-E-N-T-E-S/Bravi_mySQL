package br.com.Bravi.entidades.fornece;

import br.com.Bravi.exceptions.ForneceNaoEncontradoException;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornece")
public class ForneceController {

    private final ForneceService forneceService;

    @Autowired
    public ForneceController(ForneceService forneceService) {
        this.forneceService = forneceService;
    }

    @PostMapping
    public ResponseEntity<String> inserirFornece(@RequestBody Fornece fornece) {
        try {
            forneceService.inserirFornece(fornece);
            return new ResponseEntity<>("Fornecedor inserido com sucesso!", HttpStatus.CREATED);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFornece(@PathVariable int id, @RequestBody Fornece fornece) {
        fornece.setId(id);
        try {
            forneceService.atualizarFornece(fornece);
            return new ResponseEntity<>("Fornecedor atualizado com sucesso!", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFornece(@PathVariable int id) {
        try {
            forneceService.excluirFornece(id);
            return new ResponseEntity<>("Fornecedor excluído com sucesso!", HttpStatus.OK);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornece>> listarFornece() {
        List<Fornece> forneceList = forneceService.listarFornece();
        return ResponseEntity.ok(forneceList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornece> buscarFornecePorId(@PathVariable int id) {
        Fornece fornece = forneceService.buscarFornecePorId(id);
        if (fornece == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(fornece);
    }
}
