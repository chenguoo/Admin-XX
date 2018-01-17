package com.javamokey.adminxx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AdminXxApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdminXxApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdminXxApplication.class);
	}




}
