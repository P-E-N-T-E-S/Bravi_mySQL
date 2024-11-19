package br.com.Bravi.dashboard;

import java.util.List;
import java.util.Map;

public interface DashboardRepository {

    Map<String, Object> getFaturamento();

    Map<String, Object> getMeta();

    Map<String, Object> getLucro();

    List<Map<String, Object>>  getEvolucaoVendas();

    List<Map<String, Object>> getLucroPorAno();

    Map<String, Object> getMaioresCompradores();

    List<String> getCategorias();
}
