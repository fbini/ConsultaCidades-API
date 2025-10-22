package br.com.bini.buscadorClimatico;

import br.com.bini.buscadorClimatico.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BuscadorClimaticoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BuscadorClimaticoApplication.class, args);
	}

	@Override
	public void run(String... args){
		Principal principal = new Principal();
		new Principal().exibeMenu();

	}
}
