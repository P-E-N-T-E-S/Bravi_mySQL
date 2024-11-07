package br.com.Bravi.entidades.compra;

import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compra")
public class CompraController {

    private final CompraService compraService;

    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody Compra compra) {
        try {
            compraService.inserirCompra(compra);
            return ResponseEntity.status(HttpStatus.CREATED).body("Compra criada com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Compra compra) {
        compra.setId(id);
        try {
            compraService.atualizarCompra(compra);
            return ResponseEntity.ok("Compra atualizada com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
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
