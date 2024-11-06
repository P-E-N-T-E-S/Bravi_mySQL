package br.com.Bravi.entidades.compra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService compraService;

    @Autowired
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<Void> inserir(@RequestBody Compra compra) {
        compraService.inserirCompra(compra);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> atualizar(@PathVariable int id, @RequestBody Compra compra) {
        compra.setId(id);
        compraService.atualizarCompra(compra);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        compraService.excluirCompra(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar() {
        List<Compra> compraList = compraService.listarCompra();
        return ResponseEntity.ok(compraList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable int id) {
        Compra compra = compraService.buscarCompraPorId(id);
        if (compra != null) {
            return ResponseEntity.ok(compra);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
