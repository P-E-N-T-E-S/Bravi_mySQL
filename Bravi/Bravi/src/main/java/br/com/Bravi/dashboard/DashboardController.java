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
        return dashboardService.getFaturamento();
    }

    @GetMapping("/meta")
    public Map<String, Object> getMeta() {
        return dashboardService.getMeta();
    }

    @GetMapping("/lucro")
    public Map<String, Object> getLucro() {
        return dashboardService.getLucro();
    }

    @GetMapping("/evolucao-vendas")
    public List<Double> getEvolucaoVendas() {
        return dashboardService.getEvolucaoVendas();
    }

    @GetMapping("/faturamento-por-ano")
    public Map<Integer, Double> getFaturamentoPorAno() {
        return dashboardService.getFaturamentoPorAno();
    }

    @GetMapping("/maiores-compradores")
    public List<Map<String, String>> getMaioresCompradores() {
        return dashboardService.getMaioresCompradores();
    }

    @GetMapping("/maiores-fornecedores")
    public List<Map<String, String>> getMaioresFornecedores() {
        return dashboardService.getMaioresFornecedores();
    }

    @GetMapping("/categorias")
    public List<String> getCategorias() {
        return dashboardService.getCategorias();
    }
}
