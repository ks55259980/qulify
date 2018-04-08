package com.spoonsea.qualitytracing.configuration;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "limsEntityManagerFactory", transactionManagerRef = "limsTransactionManager", basePackages = {
        LimsJpaConfig.basePackage })
public class LimsJpaConfig {

    public static final String basePackage = "com.spoonsea.qualitytracing.lims";

    private final String persistenceUnit = this.getClass().getSimpleName();

    @Autowired
    @Qualifier("limsDataSource")
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("limsEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean("limsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource).properties(getVendorProperties(dataSource))
                .packages(LimsJpaConfig.basePackage).persistenceUnit(persistenceUnit).build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
        // Map<String, String> properties = jpaProperties.getHibernateProperties(dataSource);
        // properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServer2008Dialect");
        // return properties;
    }

    @Bean("limsTransactionManager")
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
