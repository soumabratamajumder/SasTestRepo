package com.sas.config;

import java.util.HashMap;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
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
@EnableJpaRepositories(
		entityManagerFactoryRef = "lgdEntityManagerFactory", 
		transactionManagerRef = "lgdTransactionManager",  
		basePackages = {
				"com.sas.repositories.lgd" }
		)
public class LgdDBConfig {
	
	@Bean(name = "lgdDataSource")
	@ConfigurationProperties(prefix = "spring.lgd.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean(name = "lgdEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("lgdDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		
		// properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.sas.model.lgd").persistenceUnit("Lgd").build();
	}

	
	@Bean(name = "LgdTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("lgdEntityManagerFactory") EntityManagerFactory lgdEntityManagerFactory) {
		return new JpaTransactionManager(lgdEntityManagerFactory);
	}

}
