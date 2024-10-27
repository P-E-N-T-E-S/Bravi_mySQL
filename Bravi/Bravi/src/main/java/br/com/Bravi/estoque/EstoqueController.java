package br.com.Bravi.estoque;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    public EstoqueController(EstoqueService estoqueService) {
        this.estoqueService = estoqueService;
    }

    @PostMapping
    public ResponseEntity<Void> adicionarEstoque(@RequestBody Estoque estoque) {
        estoqueService.adicionarEstoque(estoque);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> atualizarEstoque(@RequestBody Estoque estoque) {
        estoqueService.atualizarEstoque(estoque);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{setor}/{produtoNsm}")
    public ResponseEntity<Void> removerEstoque(@PathVariable int setor, @PathVariable int produtoNsm) {
        estoqueService.removerEstoque(setor, produtoNsm);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> listarEstoque() {
        List<Estoque> estoqueList = estoqueService.listarEstoque();
        return ResponseEntity.ok(estoqueList);
    }

    @GetMapping("/{setor}/{produtoNsm}")
    public ResponseEntity<Estoque> buscarEstoquePorId(@PathVariable int setor, @PathVariable int produtoNsm) {
        Estoque estoque = estoqueService.buscarEstoquePorId(setor, produtoNsm);
        return estoque != null ? ResponseEntity.ok(estoque) : ResponseEntity.notFound().build();
    }
}
