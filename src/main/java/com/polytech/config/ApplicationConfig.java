package com.polytech.config;

import com.polytech.business.PublicationService;
import com.polytech.business.PublicationServiceImpl;
import com.polytech.repository.JdbcPostRepository;
import com.polytech.repository.PostRepository;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * Created by daivietquochoang on 13/03/2017.
 */
@Configuration
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = "com.polytech")

public class ApplicationConfig {
    @Autowired
    private Environment environment;

/*    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUsername(environment.getProperty("datasource.username"));
        dataSource.setPassword(environment.getProperty("datasource.password"));
        dataSource.setUrl(environment.getProperty("datasource.url"));
        dataSource.setDriverClassName(environment.getProperty("datasource.driverName"));
        return dataSource;
    }*/

    @Bean//(name="dataSource")
    @Profile("PROD")
    public DataSource prodDataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUsername(environment.getProperty("datasource.username"));
        basicDataSource.setPassword(environment.getProperty("datasource.password"));
        basicDataSource.setUrl(environment.getProperty("datasource.url"));
        basicDataSource.setDriverClassName(environment.getProperty("datasource.driverName"));
        return basicDataSource;
    }

    @Bean//(name="dataSource")
    @Profile("DEV")
    public DataSource devDataSource(){
        EmbeddedDatabaseBuilder embeddedDatabaseBuilder = new EmbeddedDatabaseBuilder();
        return embeddedDatabaseBuilder.setType(EmbeddedDatabaseType.H2).addScript("create-schema.sql").build();
    }


}
