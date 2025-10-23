package br.com.bini.buscadorCidades;

import br.com.bini.buscadorCidades.principal.Principal;
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
		new Principal().exibeMenu();

	}
}
