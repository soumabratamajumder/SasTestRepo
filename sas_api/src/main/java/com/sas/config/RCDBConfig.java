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
		entityManagerFactoryRef = "rcEntityManagerFactory", 
		transactionManagerRef = "rcTransactionManager",  
		basePackages = {
				"com.sas.rc.repositories" }
		)
public class RCDBConfig {
	
	@Bean(name = "rcDataSource")
	@ConfigurationProperties(prefix = "spring.rc.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	
	@Bean(name = "rcEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("rcDataSource") DataSource dataSource) {
		HashMap<String, Object> properties = new HashMap<>();
		
		// properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		return builder.dataSource(dataSource).properties(properties)
				.packages("com.sas.rc.model").persistenceUnit("Rc").build();
	}

	
	@Bean(name = "RcTransactionManager")
	public PlatformTransactionManager transactionManager(
			@Qualifier("rcEntityManagerFactory") EntityManagerFactory rcEntityManagerFactory) {
		return new JpaTransactionManager(rcEntityManagerFactory);
	}

}
