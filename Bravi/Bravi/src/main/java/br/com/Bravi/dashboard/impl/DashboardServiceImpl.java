package br.com.Bravi.dashboard.impl;

import br.com.Bravi.dashboard.DashboardRepository;
import br.com.Bravi.dashboard.DashboardService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    private final DashboardRepository dashboardRepository;

    public DashboardServiceImpl(DashboardRepository dashboardRepository) {
        this.dashboardRepository = dashboardRepository;
    }

    @Override
    public Map<String, Object> getFaturamento() {
        try {
            return dashboardRepository.getFaturamento();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter faturamento", e);
        }
    }

    @Override
    public Map<String, Object> getMeta() {
        try {
            return dashboardRepository.getMeta();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter meta", e);
        }
    }

    @Override
    public Map<String, Object> getLucro() {
        try {
            return dashboardRepository.getLucro();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter lucro", e);
        }
    }

    @Override
    public List<Map<String, Object>> getEvolucaoVendas() {
        List<Map<String, Object>> data = dashboardRepository.getEvolucaoVendas();
        List<Map<String, Object>> evolucaoVendas = new ArrayList<>();

        for (Map<String, Object> row : data) {
            Map<String, Object> map = new HashMap<>();
            map.put("ano", row.get("ano"));
            Object valor = row.get("total_vendas");

            if (valor != null) {
                map.put("valor", ((BigDecimal) valor).doubleValue());
            } else {
                map.put("valor", 0.0);
            }

            evolucaoVendas.add(map);
        }

        return evolucaoVendas;
    }

    @Override
    public Map<String, Object> getLucroPorAno() {
        try {
            List<Map<String, Object>> query = dashboardRepository.getLucroPorAno();
            List<String> anos = new ArrayList<>();
            List<Double> lucros = new ArrayList<>();
            for (Map<String, Object> map : query) {
                anos.add(map.get("ano").toString());
                lucros.add(((BigDecimal) map.get("lucro")).doubleValue());
            }
            Map<String, Object> resposta = new HashMap<>();
            resposta.put("anos", anos);
            resposta.put("lucros", lucros);
            return resposta;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter lucro por ano", e);
        }
    }

    @Override
    public List<Map<String, String>> getMaioresCompradores() {
        try {
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
        } catch (Exception e) {
            throw new RuntimeException("Erro ao obter maiores compradores", e);
        }
    }

    @Override
    public List<Map<String, String>> getCategorias() {
        List<Map<String, Object>> categorias = dashboardRepository.getCategorias();
        List<Map<String, String>> resultMapList = new ArrayList<>();

        for (Map<String, Object> row : categorias) {
            Map<String, String> map = new HashMap<>();

            map.put("nome_categoria", (String) row.get("categoria"));
            map.put("quantidade", String.valueOf(row.get("quantidade_produtos")));

            resultMapList.add(map);
        }

        return resultMapList;
    }

}
