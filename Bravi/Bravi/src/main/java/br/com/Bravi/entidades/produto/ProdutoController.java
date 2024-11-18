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
    public String adicionarProduto(@ModelAttribute Produto produto, Model model) {
        produtoService.adicionarProduto(produto);
        model.addAttribute("mensagem", "Produto adicionado com sucesso!");
        return "redirect:/produtos";
    }

    @PostMapping("/editar/{nsm}")
    public String atualizarProduto(@PathVariable int nsm, @ModelAttribute Produto produto, Model model) {
        produto.setNsm(nsm);
        produtoService.atualizarProduto(produto);
        model.addAttribute("mensagem", "Produto atualizado com sucesso!");
        return "redirect:/produtos";
    }

    @PostMapping("/deletar/{nsm}")
    public String removerProduto(@PathVariable int nsm, Model model) {
        produtoService.removerProduto(nsm);
        model.addAttribute("mensagem", "Produto removido com sucesso!");
        return "redirect:/produtos";
    }

    @GetMapping
    public String listarProdutos(Model model) {
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
