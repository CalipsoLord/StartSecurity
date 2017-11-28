package com.startsecurity.startsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages= {"com.startsecurity.controller"})
public class StartSecurityApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder startSecurityApplication ) {
    	return startSecurityApplication.sources(StartSecurityApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(StartSecurityApplication.class, args);
	}
	
}
