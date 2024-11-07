package br.com.Bravi.entidades.estoque;

import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import br.com.Bravi.exceptions.EstoqueNotFoundException;
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
    public ResponseEntity<String> adicionarEstoque(@RequestBody Estoque estoque) {
        try {
            estoqueService.adicionarEstoque(estoque);
            return ResponseEntity.status(HttpStatus.CREATED).body("Estoque adicionado com sucesso.");
        } catch (ProdutoNaoEncontradoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<String> atualizarEstoque(@RequestBody Estoque estoque) {
        estoqueService.atualizarEstoque(estoque);
        return ResponseEntity.ok("Estoque atualizado com sucesso.");
    }

    @DeleteMapping("/{setor}/{produtoNsm}")
    public ResponseEntity<String> removerEstoque(@PathVariable int setor, @PathVariable int produtoNsm) {
        estoqueService.removerEstoque(setor, produtoNsm);
        return ResponseEntity.ok("Estoque removido com sucesso.");
    }

    @GetMapping
    public ResponseEntity<List<Estoque>> listarEstoque() {
        List<Estoque> estoqueList = estoqueService.listarEstoque();
        return ResponseEntity.ok(estoqueList);
    }

    @GetMapping("/{setor}/{produtoNsm}")
    public ResponseEntity<?> buscarEstoquePorId(@PathVariable int setor, @PathVariable int produtoNsm) {
        try {
            Estoque estoque = estoqueService.buscarEstoquePorId(setor, produtoNsm);
            return ResponseEntity.ok(estoque);
        } catch (EstoqueNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
