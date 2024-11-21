package br.com.Bravi.dashboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping
    public String showDashboard() {
        return "dashboard";
    }

    @GetMapping("/faturamento")
    public ResponseEntity<Map<String, Object>> getFaturamento() {
        Map<String, Object> response = dashboardService.getFaturamento();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/meta")
    public ResponseEntity<Map<String, Object>> getMeta() {
        Map<String, Object> response = dashboardService.getMeta();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/lucro")
    public ResponseEntity<Map<String, Object>> getLucro() {
        Map<String, Object> response = dashboardService.getLucro();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/evolucao-vendas")
    public ResponseEntity<List<Map<String, Object>>> getEvolucaoVendas() {
        List<Map<String, Object>> response = dashboardService.getEvolucaoVendas();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/lucro-por-ano")
    public ResponseEntity<Map<String, Object>> getLucroPorAno() {
        Map<String, Object> response = dashboardService.getLucroPorAno();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/maiores-compradores")
    public ResponseEntity<List<Map<String, String>>> getMaioresCompradores() {
        List<Map<String, String>> response = dashboardService.getMaioresCompradores();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<Map<String, String>>> getCategorias() {
        List<Map<String, String>> response = dashboardService.getCategorias();
        return ResponseEntity.ok(response);
    }
}
