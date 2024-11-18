package br.com.Bravi.entidades.categoria;

import br.com.Bravi.entidades.categoria.impl.CategoriaServiceImpl;
import br.com.Bravi.exceptions.CategoriaNaoEncontradaException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl categoriaService;

    public CategoriaController(CategoriaServiceImpl categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping
    public ResponseEntity<String> inserir(@RequestBody Categoria categoria) {
        try {
            categoriaService.inserir(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body("Categoria criada com sucesso");
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Erro: Categoria já existe ou violação de integridade");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable int id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        try {
            categoriaService.atualizar(categoria);
            return ResponseEntity.ok("Categoria atualizada com sucesso");
        } catch (CategoriaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        try {
            categoriaService.excluir(id);
            return ResponseEntity.ok("Categoria excluída com sucesso");
        } catch (CategoriaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping
    public String listar(Model model) {
        List<Categoria> categorias = categoriaService.listar();
        model.addAttribute("categorias", categorias);
        return "categorias";
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable int id) {
        try {
            Categoria categoria = categoriaService.buscarPorId(id);
            return ResponseEntity.ok(categoria);
        } catch (CategoriaNaoEncontradaException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
