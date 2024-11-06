package br.com.Bravi.entidades.fornece;

import org.springframework.beans.factory.annotation.Autowired;
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
        forneceService.inserirFornece(fornece);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizarFornece(@PathVariable int id, @RequestBody Fornece fornece) {
        fornece.setId(id);
        forneceService.atualizarFornece(fornece);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornece(@PathVariable int id) {
        forneceService.excluirFornece(id);
        return ResponseEntity.ok().build();
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
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(fornece);
    }
}
