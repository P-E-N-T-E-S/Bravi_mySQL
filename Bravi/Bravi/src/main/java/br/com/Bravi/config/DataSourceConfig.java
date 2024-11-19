package br.com.Bravi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import io.github.cdimascio.dotenv.Dotenv;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    Dotenv dotenv = Dotenv.load();

    private String datasourceUrl = dotenv.get("DATABASE_URL");
    private String datasourceUsername = dotenv.get("DATABASE_USERNAME");
    private String datasourcePassword = dotenv.get("DATABASE_PASSWORD");

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