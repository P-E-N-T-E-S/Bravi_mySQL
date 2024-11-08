package br.com.Bravi.dashboard;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    Map<String, Object> getFaturamento();

    Map<String, Object> getMeta();

    Map<String, Object> getLucro();

    List<Double> getEvolucaoVendas();

    Map<String, Object> getFaturamentoPorAno();

    List<Map<String, String>> getMaioresCompradores();

    List<String> getCategorias();
}
