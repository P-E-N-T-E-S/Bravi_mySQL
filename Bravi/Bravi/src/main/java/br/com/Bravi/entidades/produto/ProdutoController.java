package br.com.Bravi.entidades.produto;

import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<String> adicionarProduto(@RequestBody Produto produto) {
        produtoService.adicionarProduto(produto);
        return new ResponseEntity<>("Produto adicionado com sucesso!", HttpStatus.CREATED);
    }

    @PutMapping("/{nsm}")
    public ResponseEntity<String> atualizarProduto(@PathVariable int nsm, @RequestBody Produto produto) {
        produto.setNsm(nsm);
        try {
            produtoService.atualizarProduto(produto);
            return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{nsm}")
    public ResponseEntity<String> removerProduto(@PathVariable int nsm) {
        try {
            produtoService.removerProduto(nsm);
            return new ResponseEntity<>("Produto removido com sucesso!", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @GetMapping("/{nsm}")
    public ResponseEntity<Produto> obterProdutoPorNsm(@PathVariable int nsm) {
        Produto produto = produtoService.obterProdutoPorNsm(nsm);
        if (produto == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
