package co.usa.ciclo3.ciclo3.jar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = {"co.usa.ciclo3.ciclo3.jar.model"})
@SpringBootApplication
public class JarApplication {

	public static void main(String[] args) {
		SpringApplication.run(JarApplication.class, args);
	}

}
