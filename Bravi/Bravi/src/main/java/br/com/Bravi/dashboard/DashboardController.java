package br.com.Bravi.dashboard;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService) {
        this.dashboardService = dashboardService;
    }

    @GetMapping("/faturamento")
    public Map<String, Object> getFaturamento() {
        try {
            return dashboardService.getFaturamento();
        } catch (Exception e) {
            return Map.of("error", "Erro ao obter faturamento: " + e.getMessage());
        }
    }

    @GetMapping("/meta")
    public Map<String, Object> getMeta() {
        try {
            return dashboardService.getMeta();
        } catch (Exception e) {
            return Map.of("error", "Erro ao obter meta: " + e.getMessage());
        }
    }

    @GetMapping("/lucro")
    public Map<String, Object> getLucro() {
        try {
            return dashboardService.getLucro();
        } catch (Exception e) {
            return Map.of("error", "Erro ao obter lucro: " + e.getMessage());
        }
    }

    @GetMapping("/evolucao-vendas")
    public List<Double> getEvolucaoVendas() {
        try {
            return dashboardService.getEvolucaoVendas();
        } catch (Exception e) {
            return List.of();
        }
    }

    @GetMapping("/faturamento-por-ano")
    public Map<String, Object> getFaturamentoPorAno() {
        try {
            return dashboardService.getFaturamentoPorAno();
        } catch (Exception e) {
            return Map.of("error", "Erro ao obter faturamento por ano: " + e.getMessage());
        }
    }

    @GetMapping("/maiores-compradores")
    public List<Map<String, String>> getMaioresCompradores() {
        try {
            return dashboardService.getMaioresCompradores();
        } catch (Exception e) {
            return List.of();
        }
    }

    @GetMapping("/categorias")
    public List<String> getCategorias() {
        try {
            return dashboardService.getCategorias();
        } catch (Exception e) {
            return List.of();
        }
    }
}
