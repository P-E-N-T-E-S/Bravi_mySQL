package br.com.Bravi.dashboard.impl;

import br.com.Bravi.dashboard.DashboardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@Repository
public class DashboardRepositoryImpl implements DashboardRepository {

    private final JdbcTemplate jdbcTemplate;

    public DashboardRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Map<String, Object> getFaturamento() {
        String sql = "SELECT SUM(valor) AS valor, (SUM(valor) - LAG(SUM(valor), 1) OVER()) / LAG(SUM(valor), 1) * 100 AS variacaoAnual FROM faturamento";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> getMeta() {
        String sql = "SELECT percentual, variacaoAnual FROM metas WHERE id = 1";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> getLucro() {
        String sql = "SELECT percentual, variacaoAnual FROM lucro WHERE id = 1";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public List<Double> getEvolucaoVendas() {
        String sql = "SELECT valor FROM vendas ORDER BY ano";
        return jdbcTemplate.queryForList(sql, Double.class);
    }

    @Override
    public Map<String, Object> getMaioresCompradores() {
        String sql = "SELECT nome, valor, ativo FROM compradores ORDER BY valor DESC LIMIT 5";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("maiores_compradores", result);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> getFaturamentoPorAno() {
        String sql = "SELECT ano, SUM(valor) AS valor FROM faturamento GROUP BY ano ORDER BY ano";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<String> getCategorias() {
        String sql = "SELECT nome FROM categorias";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
