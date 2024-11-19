package br.com.Bravi.dashboard;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
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

    @GetMapping("/")
    public String showDashboard() {
        return "dashboard";
    }

    @GetMapping("/faturamento")
    public ResponseEntity<Map<String, Object>> getFaturamento() {
        try {
            return new ResponseEntity(dashboardService.getFaturamento(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/meta")
    public ResponseEntity<Map<String, Object>> getMeta() {
        try {
            return new ResponseEntity(dashboardService.getMeta(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/lucro")
    public ResponseEntity<Map<String, Object>> getLucro() {
        try {
            return new ResponseEntity(dashboardService.getLucro(), HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/evolucao-vendas")
    public ResponseEntity<List<Double>> getEvolucaoVendas() {
        try {
            return new ResponseEntity(dashboardService.getEvolucaoVendas(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/lucro-por-ano")
    public ResponseEntity<Map<String, Object>> getLucroPorAno() {
        try {
            return new ResponseEntity(dashboardService.getLucroPorAno(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/maiores-compradores")
    public ResponseEntity<List<Map<String, String>>> getMaioresCompradores() {
        try {
            return new ResponseEntity(dashboardService.getMaioresCompradores(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/categorias")
    public ResponseEntity<List<String>> getCategorias() {
        try {
            return new ResponseEntity(dashboardService.getCategorias(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
