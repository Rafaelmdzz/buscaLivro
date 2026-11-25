package br.com.rafael.livro;

import br.com.rafael.livro.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LivroApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LivroApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.exibirmenu();
	}
}
