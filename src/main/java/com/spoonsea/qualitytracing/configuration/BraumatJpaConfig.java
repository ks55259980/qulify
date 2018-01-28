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
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "braumatEntityManagerFactory", transactionManagerRef = "braumatTransactionManager", basePackages = {
        BraumatJpaConfig.basePackage })
public class BraumatJpaConfig {

    public static final String basePackage = "com.spoonsea.qualitytracing.braumat";

    private final String persistenceUnit = this.getClass().getSimpleName();

    @Autowired
    @Qualifier("braumatDataSource")
    private DataSource dataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean("braumatEntityManager")
    @Primary
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactory(builder).getObject().createEntityManager();
    }

    @Bean("braumatEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(dataSource).properties(getVendorProperties(dataSource))
                .packages(BraumatJpaConfig.basePackage).persistenceUnit(persistenceUnit).build();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean("braumatTransactionManager")
    @Primary
    PlatformTransactionManager transactionManager(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactory(builder).getObject());
    }

}
