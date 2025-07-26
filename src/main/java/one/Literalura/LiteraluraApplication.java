package one.Literalura;

import one.Literalura.model.DataBook;
import one.Literalura.principal.Main;
import one.Literalura.service.ConsumoApi;
import one.Literalura.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		ConsumoApi consumo = new ConsumoApi();
//		var json = consumo.ObterDados("https://gutendex.com/books/?search=dickens%20great");
//
//
//		ConverteDados conversor = new ConverteDados();
//		DataBook dados = conversor.obterDados(json, DataBook.class);

		Main principal = new Main();
		principal.showMenu();
	}
}
