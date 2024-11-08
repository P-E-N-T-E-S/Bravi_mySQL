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
    public ResponseEntity<Void> inserirFornece(@RequestBody Fornece fornece) {
        try {
            forneceService.inserirFornece(fornece);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    public ResponseEntity<Void> atualizarFornece(@RequestBody Fornece fornece) {
        try {
            forneceService.atualizarFornece(fornece);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException | ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornece(@PathVariable int id) {
        try {
            forneceService.excluirFornece(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornece>> listarFornece() {
        return new ResponseEntity<>(forneceService.listarFornece(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornece> buscarFornecePorId(@PathVariable int id) {
        try {
            Fornece fornece = forneceService.buscarFornecePorId(id);
            return new ResponseEntity<>(fornece, HttpStatus.OK);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
