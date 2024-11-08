package br.com.Bravi.dashboard.impl;

import br.com.Bravi.dashboard.DashboardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;

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
    public Map<Integer, Double> getFaturamentoPorAno() {
        String sql = "SELECT ano, SUM(valor) AS faturamento FROM faturamento GROUP BY ano";
        List<Map<String, Object>> resultList = jdbcTemplate.queryForList(sql);

        Map<Integer, Double> faturamentoPorAno = new HashMap<>();
        for (Map<String, Object> row : resultList) {
            Integer ano = (Integer) row.get("ano");
            Double faturamento = (Double) row.get("faturamento");
            faturamentoPorAno.put(ano, faturamento);
        }
        return faturamentoPorAno;
    }

    @Override
    public List<Map<String, String>> getMaioresCompradores() {
        String sql = "SELECT nome, valor, ativo FROM compradores ORDER BY valor DESC LIMIT 5";
        return jdbcTemplate.queryForList(sql).stream()
                .map(row -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("nome", (String) row.get("nome"));
                    map.put("valor", String.valueOf(row.get("valor")));
                    map.put("ativo", String.valueOf(row.get("ativo")));
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<Map<String, String>> getMaioresFornecedores() {
        String sql = "SELECT nome FROM fornecedores ORDER BY nome";
        return jdbcTemplate.queryForList(sql).stream()
                .map(row -> {
                    Map<String, String> map = new HashMap<>();
                    map.put("nome", (String) row.get("nome"));
                    return map;
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getCategorias() {
        String sql = "SELECT nome FROM categorias";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
