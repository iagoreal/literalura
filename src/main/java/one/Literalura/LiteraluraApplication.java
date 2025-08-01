package one.Literalura;

import one.Literalura.model.DataBook;
import one.Literalura.principal.Main;
import one.Literalura.repository.RepositoryAuthor;
import one.Literalura.repository.RepositoryBook;
import one.Literalura.service.ConsumoApi;
import one.Literalura.service.ConverteDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	private RepositoryBook repositoryBook;
	private RepositoryAuthor repositoryAuthor;


    public LiteraluraApplication(RepositoryBook repositoryBook, RepositoryAuthor repositoryAuthor) {
        this.repositoryBook = repositoryBook;
		this.repositoryAuthor = repositoryAuthor;
    }

    public static void main(String[] args) {

		SpringApplication.run(LiteraluraApplication.class, args);


	}

	@Override
	public void run(String... args) throws Exception {

		Main principal = new Main(repositoryBook, repositoryAuthor);
		principal.showMenu();
	}
}
