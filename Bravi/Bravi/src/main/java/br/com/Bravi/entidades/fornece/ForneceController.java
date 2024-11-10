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

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFornece(@PathVariable int id, @RequestBody Fornece fornece) {
        fornece.setId(id);
        try {
            forneceService.atualizarFornece(fornece);
            return new ResponseEntity<>("Fornecedor atualizado com sucesso!", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException | ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFornece(@PathVariable int id) {
        try {
            forneceService.excluirFornece(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Fornece>> listarFornece() {
        return new ResponseEntity<>(forneceService.listarFornece(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> buscarFornecePorId(@PathVariable int id) {
        try {
            Fornece fornece = forneceService.buscarFornecePorId(id);
            return new ResponseEntity<>(fornece.toString(), HttpStatus.OK);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
