package it.softwaredoctor.angularproject;

import it.softwaredoctor.angularproject.model.Product;
import it.softwaredoctor.angularproject.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AngularprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(AngularprojectApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(ProductRepository productRepository) {
		return (args) -> {
			productRepository.save(new Product("Laptop", 999.99));
			productRepository.save(new Product("Smartphone", 499.99));
			productRepository.save(new Product("Tablet", 299.99));
		};
	}
}
