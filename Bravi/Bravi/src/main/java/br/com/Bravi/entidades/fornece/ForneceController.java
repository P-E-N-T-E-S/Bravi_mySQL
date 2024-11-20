package br.com.Bravi.entidades.fornece;

import br.com.Bravi.entidades.cliente.ClienteService;
import br.com.Bravi.entidades.fornecedor.FornecedorService;
import br.com.Bravi.entidades.produto.ProdutoService;
import br.com.Bravi.exceptions.ForneceNaoEncontradoException;
import br.com.Bravi.exceptions.FornecedorNaoEncontradoException;
import br.com.Bravi.exceptions.ProdutoNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/pedidos")
public class ForneceController {

    private final ForneceService forneceService;

    private final ProdutoService produtoService;
    private final FornecedorService fornecedorService;

    @Autowired
    public ForneceController(ForneceService forneceService, ProdutoService produtoService, FornecedorService fornecedorService) {
        this.forneceService = forneceService;
        this.produtoService = produtoService;
        this.fornecedorService = fornecedorService;
    }

    @PostMapping
    public ResponseEntity<String> inserirFornece(@RequestBody Fornece fornece) {
        try {
            forneceService.inserirFornece(fornece);
            return new ResponseEntity<>("Fornecedor inserido com sucesso!", HttpStatus.CREATED);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarFornece(@PathVariable int id, @RequestBody Fornece fornece) {
        fornece.setId(id);
        try {
            forneceService.atualizarFornece(fornece);
            return new ResponseEntity<>("Fornecedor atualizado com sucesso!", HttpStatus.OK);
        } catch (ProdutoNaoEncontradoException | FornecedorNaoEncontradoException | ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirFornece(@PathVariable int id) {
        try {
            forneceService.excluirFornece(id);
            return new ResponseEntity<>("Fornecedor excluído com sucesso!", HttpStatus.NO_CONTENT);
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public String listarFornece(Model model) {
        List<Fornece> pedidos = forneceService.listarFornece();
        model.addAttribute("produtos", produtoService.listarProdutos());
        model.addAttribute("fornecedores", fornecedorService.listarFornecedores());
        model.addAttribute("pedidos", pedidos);
        return "pedidos";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornece> buscarFornecePorId(@PathVariable int id) {
        try {
            Fornece fornece = forneceService.buscarFornecePorId(id);
            return new ResponseEntity<>(fornece, HttpStatus.OK); // Retorna o objeto como JSON
        } catch (ForneceNaoEncontradoException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
