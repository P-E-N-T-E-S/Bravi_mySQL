package br.com.Bravi.dashboard;

import java.util.List;
import java.util.Map;

public interface DashboardService {

    Map<String, Object> getFaturamento();

    Map<String, Object> getMeta();

    Map<String, Object> getLucro();

    List<Map<String, Object>> getEvolucaoVendas();

    Map<String, Object> getLucroPorAno();

    List<Map<String, String>> getMaioresCompradores();

    List<Map<String, String>> getCategorias();
}
