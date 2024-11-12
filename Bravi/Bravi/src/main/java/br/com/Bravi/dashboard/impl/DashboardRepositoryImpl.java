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
        String sql = "SELECT SUM(valor) AS valor FROM _Compra";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> getMeta() {
        String sql = "SELECT SUM(valor) AS meta_2023 FROM _Compra WHERE YEAR(data) = 2023";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public Map<String, Object> getLucro() {
        String sql = "SELECT (SELECT SUM(valor) FROM _Compra) - " +
                "(SELECT SUM(f.valor) FROM _Fornece f JOIN _Compra fc ON f.fk_Produto_NSM = fc.fk_Produto_NSM) AS lucro";
        return jdbcTemplate.queryForMap(sql);
    }

    @Override
    public List<Double> getEvolucaoVendas() {
        String sql = "SELECT SUM(valor) FROM _Compra GROUP BY YEAR(data)";
        return jdbcTemplate.queryForList(sql, Double.class);
    }

    @Override
    public Map<String, Object> getMaioresCompradores() {
        String sql = "SELECT c.Nome, SUM(v.valor) AS total_compras FROM _Compra v JOIN Cliente c " +
                "ON v.fk_Cliente_CNPJ = c.CNPJ GROUP BY c.Nome ORDER BY total_compras DESC LIMIT 5";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("maiores_compradores", result);
        return resultMap;
    }

    @Override
    public List<Map<String, Object>> getFaturamentoPorAno() {
        String sql = "SELECT YEAR(data) AS ano, SUM(valor) AS valor FROM _Compra GROUP BY ano ORDER BY ano";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<String> getCategorias() {
        String sql = "SELECT nome FROM Categoria";
        return jdbcTemplate.queryForList(sql, String.class);
    }
}
