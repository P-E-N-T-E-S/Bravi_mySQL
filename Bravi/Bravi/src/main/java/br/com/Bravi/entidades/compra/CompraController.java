package br.com.Bravi.entidades.compra;

import br.com.Bravi.entidades.cliente.ClienteService;
import br.com.Bravi.entidades.produto.ProdutoService;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import br.com.Bravi.exceptions.CompraNaoEncontradaException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendas")
public class CompraController {

    private final CompraService compraService;
    private final ProdutoService produtoService;
    private final ClienteService clienteService;

    public CompraController(CompraService compraService, ProdutoService produtoService, ClienteService clienteService) {
        this.compraService = compraService;
        this.produtoService = produtoService;
        this.clienteService = clienteService;
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

    @PutMapping("/{id}")
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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping
    public String listarCompra(Model model) {
        List<Compra> compras = compraService.listarCompra();
        model.addAttribute("compras", compras);

        model.addAttribute("produtos", produtoService.listarProdutos());
        model.addAttribute("clientes", clienteService.listar());

        return "vendas";
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listar() {
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
