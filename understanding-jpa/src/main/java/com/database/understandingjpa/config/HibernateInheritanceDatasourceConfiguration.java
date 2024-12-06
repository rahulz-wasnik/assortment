package com.database.understandingjpa.config;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "hibernateInheritanceEntityManagerFactory",
        transactionManagerRef = "hibernateInheritanceTransactionManager",
        basePackages = {"com.database.understandingjpa.repository.hibernate.inheritance"})
public class HibernateInheritanceDatasourceConfiguration {

    @Bean(name = "hibernateInheritanceProperties")
    @ConfigurationProperties("spring.datasource.hibernate-inheritance")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "hibernateInheritanceDatasource")
    @ConfigurationProperties(prefix = "spring.datasource.hibernate-inheritance")
    public DataSource datasource(@Qualifier("hibernateInheritanceProperties") DataSourceProperties properties) {
        return properties.initializeDataSourceBuilder().build();
    }

    @Bean(name = "hibernateInheritanceEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean
            (EntityManagerFactoryBuilder builder,
             @Qualifier("hibernateInheritanceDatasource") DataSource dataSource) {

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "create");

        return builder.dataSource(dataSource).properties(properties)
                .packages("com.database.understandingjpa.entity.hibernate.inheritance")
                .persistenceUnit("hibernateInheritance").build();
    }

    @Bean(name = "hibernateInheritanceTransactionManager")
    @ConfigurationProperties("spring.jpa")
    public PlatformTransactionManager transactionManager(
            @Qualifier("hibernateInheritanceEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}