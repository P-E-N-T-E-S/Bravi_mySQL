package br.com.Bravi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Value("${my.app.datasource_url}")
    private String datasourceUrl;
    @Value("${my.app.datasource_username}")
    private String datasourceUsername;
    @Value("${my.app.datasource_password}")
    private String datasourcePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl(datasourceUrl);
        dataSource.setUsername(datasourceUsername);
        if (datasourcePassword.equals("vazio")){
            dataSource.setPassword("");
        }else{
            dataSource.setPassword(datasourcePassword);
        }
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}