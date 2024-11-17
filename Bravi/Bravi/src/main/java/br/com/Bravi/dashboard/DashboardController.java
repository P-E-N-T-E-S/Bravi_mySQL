package br.com.Bravi.dashboard;

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

    @GetMapping("/")
    public String showDashboard() {
        return "dashboard";
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

    @GetMapping("/lucro-por-ano")
    public Map<String, Object> getLucroPorAno() {
        try {
            return dashboardService.getLucroPorAno();
        } catch (Exception e) {
            return Map.of("error", "Erro ao obter lucro por ano: " + e.getMessage());
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
