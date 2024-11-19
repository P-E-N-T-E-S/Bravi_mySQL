package br.com.Bravi.entidades.produto;

import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public String handleProdutoNaoEncontradoException(ProdutoNaoEncontradoException e, Model model) {
        model.addAttribute("erro", e.getMessage());
        return "erro";
    }

    @PostMapping
    public ResponseEntity<String> adicionarProduto(@RequestBody Produto produto) {
        produtoService.adicionarProduto(produto);
        return new ResponseEntity<>("Produto adicionado com sucesso!", HttpStatus.OK);
    }

    @PutMapping("/{nsm}")
    public ResponseEntity<String> atualizarProduto(@PathVariable int nsm, @RequestBody Produto produto) {
        produtoService.atualizarProduto(produto, nsm);
        return new ResponseEntity<>("Produto atualizado com sucesso!", HttpStatus.OK);
    }

    @DeleteMapping("/{nsm}")
    public ResponseEntity<String> removerProduto(@PathVariable int nsm) {
        produtoService.removerProduto(nsm);
        return new ResponseEntity<>("Produto deletado com sucesso!", HttpStatus.OK);
    }

    @GetMapping
    public String paginaInicialProdutos(Model model) {
        List<Produto> produtos = produtoService.listarProdutos();
        model.addAttribute("produtos", produtos);
        return "produtos";
    }

    @GetMapping("/{nsm}")
    public ResponseEntity<Produto> obterProdutoPorNsm(@PathVariable int nsm) {
        Produto produto = produtoService.obterProdutoPorNsm(nsm);
        return new ResponseEntity<>(produto, HttpStatus.OK);
    }
}
