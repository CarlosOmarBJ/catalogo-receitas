package com.example.catalogo_receitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.exemplo.receitas"})
@EntityScan("com.exemplo.receitas.model")
@EnableJpaRepositories("com.exemplo.receitas.repository")
public class CatalogoReceitasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CatalogoReceitasApplication.class, args);
	}

}
