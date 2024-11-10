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
    public ResponseEntity<String> inserir(@RequestBody Compra compra) {
        try {
            compraService.inserirCompra(compra);
            return ResponseEntity.status(HttpStatus.CREATED).body("Compra criada com sucesso.");
        } catch (ClienteNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro inesperado: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Compra compra) {
        compra.setId(id);
        try {
            compraService.atualizarCompra(compra);
            return ResponseEntity.ok("Compra atualizada com sucesso.");
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao atualizar a compra: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            compraService.excluirCompra(id);
            return ResponseEntity.noContent().build();
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao excluir a compra: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Compra>> listar() {
        List<Compra> compraList = compraService.listarCompra();
        return ResponseEntity.ok(compraList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> buscarPorId(@PathVariable int id) {
        try {
            Compra compra = compraService.buscarCompraPorId(id);
            return ResponseEntity.ok(compra);
        } catch (CompraNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
