package br.com.Bravi.dashboard.impl;

import br.com.Bravi.dashboard.DashboardRepository;
import br.com.Bravi.dashboard.DashboardService;
import org.springframework.stereotype.Service;

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
    public Map<Integer, Double> getFaturamentoPorAno() {
        return dashboardRepository.getFaturamentoPorAno();
    }

    @Override
    public List<Map<String, String>> getMaioresFornecedores() {
        return dashboardRepository.getMaioresFornecedores();
    }

    @Override
    public List<Map<String, String>> getMaioresCompradores() {
        return dashboardRepository.getMaioresCompradores();
    }

    @Override
    public List<String> getCategorias() {
        return dashboardRepository.getCategorias();
    }
}
