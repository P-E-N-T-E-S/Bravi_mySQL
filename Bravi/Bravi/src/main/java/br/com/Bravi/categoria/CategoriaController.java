package br.com.Bravi.categoria;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<String> criarCategoria(@RequestBody Categoria categoria) {
        categoriaService.inserir(categoria);
        return new ResponseEntity<>("Categoria criada com sucesso!", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaService.listar();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCategoriaPorId(@PathVariable int id) {
        Categoria categoria = categoriaService.buscarPorId(id);
        if (categoria != null) {
            return new ResponseEntity<>(categoria, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Categoria não encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarCategoria(@PathVariable int id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        categoriaService.atualizar(categoria);
        return new ResponseEntity<>("Categoria atualizada com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable int id) {
        categoriaService.excluir(id);
        return new ResponseEntity<>("Categoria excluída com sucesso!", HttpStatus.OK);
    }
}
