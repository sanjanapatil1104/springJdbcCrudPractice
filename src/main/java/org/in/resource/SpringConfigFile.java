package org.in.resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfigFile {
    @Bean
    public DriverManagerDataSource myDataSource()
    {
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springpractice_db");
        dataSource.setUsername("root");
        dataSource.setPassword("Root");
        return dataSource;
    }
    @Bean
    public JdbcTemplate myJdbcTemplate()
    {
        JdbcTemplate jdbcTemplate=new JdbcTemplate();
        jdbcTemplate.setDataSource(myDataSource());
        return  jdbcTemplate;
    }
}
