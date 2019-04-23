package br.com.acordocerto.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("br.com.acordocerto.domain.model")
@EnableJpaRepositories("br.com.acordocerto.domain.model")
public class AcordoCertoTestWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcordoCertoTestWebApplication.class, args);
	}

}
