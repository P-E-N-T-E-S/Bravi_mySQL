package br.com.Bravi.dashboard.impl;

import br.com.Bravi.dashboard.DashboardRepository;
import br.com.Bravi.dashboard.DashboardService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;
    private final JdbcTemplate jdbcTemplate;

    public DashboardServiceImpl(DashboardRepository dashboardRepository, JdbcTemplate jdbcTemplate) {
        this.dashboardRepository = dashboardRepository;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getFaturamento() {
        return dashboardRepository.getFaturamento();
    }

    @Override
    public Map<String, Object> getMeta() {
        return dashboardRepository.getMeta();
    }

    @Override
    public Map<String, Object> getLucro() {
        return dashboardRepository.getLucro();
    }

    @Override
    public List<Double> getEvolucaoVendas() {
        return dashboardRepository.getEvolucaoVendas();
    }

    @Override
    public Map<String, Object> getFaturamentoPorAno() {
        List<Map<String, Object>> query = dashboardRepository.getFaturamentoPorAno();
        List<String> anos = new ArrayList<>();
        List<Double> valores = new ArrayList<>();
        for (Map<String, Object> map : query) {
            anos.add(map.get("ano").toString());
            valores.add((Double) map.get("valor"));
        }
        Map<String, Object> resposta = new HashMap<>();
        resposta.put("anos", anos);
        resposta.put("valores", valores);
        return resposta;
    }

    @Override
    public List<Map<String, String>> getMaioresCompradores() {
        Map<String, Object> data = dashboardRepository.getMaioresCompradores();
        List<Map<String, String>> resultMapList = new ArrayList<>();
        List<Map<String, Object>> compradores = (List<Map<String, Object>>) data.get("maiores_compradores");
        for (Map<String, Object> row : compradores) {
            Map<String, String> map = new HashMap<>();
            map.put("nome", (String) row.get("Nome"));
            map.put("total_compras", row.get("total_compras").toString());
            resultMapList.add(map);
        }
        return resultMapList;
    }

    @Override
    public List<String> getCategorias() {
        return dashboardRepository.getCategorias();
    }
}
