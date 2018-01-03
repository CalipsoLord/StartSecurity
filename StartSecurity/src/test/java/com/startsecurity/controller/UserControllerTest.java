package com.startsecurity.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URISyntaxException;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { UserController.class})
@EntityScan("com.startsecurity.model")
@EnableJpaRepositories(basePackages="com.startsecurity.repository", entityManagerFactoryRef="entityManagerFactory")
public class UserControllerTest {
	
	
	@Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
	}
	

	public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws URISyntaxException {
	    LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource());
	    entityManagerFactoryBean.setPackagesToScan("com.startsecurity.repository");
	    //additional config of factory

	    return entityManagerFactoryBean;
	}


	public PlatformTransactionManager jpaTransactionManager(EntityManagerFactory entityManagerFactory) throws URISyntaxException {
	    JpaTransactionManager transactionManager = new JpaTransactionManager();
	    transactionManager.setEntityManagerFactory(entityManagerFactory);
	    return transactionManager;
	}
	
	@Test
    public void getHello() throws Exception {
		assertThat("Hola mundo").isEqualTo("Hola mundo");
        
    }

}
