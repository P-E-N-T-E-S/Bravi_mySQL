package br.com.Bravi.entidades.compra;

import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import br.com.Bravi.exceptions.CompraNaoEncontradaException;
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
    public ResponseEntity<Void> inserirCompra(@RequestBody Compra compra) {
        try {
            compraService.inserirCompra(compra);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (ClienteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping
    public ResponseEntity<Void> atualizarCompra(@RequestBody Compra compra) {
        try {
            compraService.atualizarCompra(compra);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCompra(@PathVariable("id") int id) {
        try {
            compraService.excluirCompra(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listarCompra() {
        List<Compra> compras = compraService.listarCompra();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarCompraPorId(@PathVariable("id") int id) {
        try {
            Compra compra = compraService.buscarCompraPorId(id);
            return ResponseEntity.ok(compra);
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
