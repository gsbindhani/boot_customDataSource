package com.boot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import com.boot.empManagement.repository.EmployeeRepository;

//Reference - https://medium.com/@joeclever/using-multiple-datasources-with-spring-boot-and-spring-data-6430b00c02e7
@Configuration
@EnableJpaRepositories(
		  entityManagerFactoryRef = "entityManagerFactory",
		  basePackageClasses = { EmployeeRepository.class }
		)
public class UserSecurtyDataSource {

	@Bean(name = "dataSource")
	@ConfigurationProperties(prefix = "user.datasource")
	@Primary
	public DataSource dataSource() {
	   return DataSourceBuilder.create().build();
	}
	
	@Bean(name = "entityManagerFactory")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(EntityManagerFactoryBuilder builder,
			@Qualifier("dataSource") DataSource dataSource) {
		return builder
				.dataSource(dataSource)
				.packages("com.boot.empManagement.dao")
				.build();
	}
}
