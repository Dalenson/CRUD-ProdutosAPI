package com.dale.projetoestudo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProjetoEstudoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoEstudoApplication.class, args);
	}

}