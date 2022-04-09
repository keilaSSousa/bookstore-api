package com.keila.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.keila.bookstore.service.DbService;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DbService dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;
	
	@Bean
	public boolean instanciarBaseDeDados() {
		if(strategy.equals("create")) {
			dbService.instanciaBaseDeDados();
		}
		
		return false;
	}

}
