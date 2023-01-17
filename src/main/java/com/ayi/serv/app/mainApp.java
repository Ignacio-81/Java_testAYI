package com.ayi.serv.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication // Spring Configuration, escanea la aplicacion para tener las entities
@EnableWebMvc //Activa las funciones de WEB y MVC (Modelo vista Cpontrolador)
@EntityScan(basePackages = { "com.ayi.serv.app.entities" })
@EnableJpaRepositories(basePackages = { "com.ayi.serv.app.repository" })
public class mainApp {

	public static void main(String[] args) {
		SpringApplication.run(mainApp.class, args);
	}

}
