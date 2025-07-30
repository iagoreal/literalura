package one.Literalura.principal;

import one.Literalura.model.Book;
import one.Literalura.model.DataBook;
import one.Literalura.model.DataResponseApi;
import one.Literalura.repository.RepositoryBook;
import one.Literalura.service.ConsumoApi;
import one.Literalura.service.ConverteDados;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private ConsumoApi consumo = new ConsumoApi();
    String endereco = "https://gutendex.com/books/?search=";
    private final ConverteDados converteDados = new ConverteDados();
    private final Scanner scanner = new Scanner(System.in);
    int chose;
    boolean condition = true;
    private RepositoryBook repository;

    public Main(RepositoryBook repositoryBook) {
        this.repository = repositoryBook;
    }

    public void showMenu() {


        while(condition){
            var menu = """
                    1 - Buscar livro
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idiomna
                   

                    0 - Sair
                    """;

            System.out.println(menu);

            try {
                if(scanner.hasNextInt()) {
                    chose = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println("Entrada inválida. Digite um número.");
                    scanner.nextLine();
                    continue;
                }
                switch (chose){
                    case 1: searchBook();
                        break;
                    case 2:

                        break;
                    case 0:
                        System.out.println("Fechando programa...");
                        condition = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private void searchBook() {
        DataResponseApi result = getBookByTilteOrAuthor();
        Book book = null;
        if (result.results() != null && !result.results().isEmpty()) {
            book = new Book(result);
            System.out.println(" ");
            System.out.println(book);

            boolean condition = true;
            while(condition) {

                try {
                    System.out.println("Estava buscando por esse livro ? \n" +
                            "1 - Sim (Será salvo na sua lista e você retornará ao menu principal) \n" +
                            "2 - Não (Cancela operação e volta ao menu princial)");


                    int option;
                    if(scanner.hasNextInt()) {
                         option = scanner.nextInt();
                        scanner.nextLine();
                    } else {
                        System.out.println("Entrada inválida. Digite um número.");
                        scanner.nextLine();
                        continue;
                    }

                    switch (option){
                        case 1:
                            saveBookSearch();
                            System.out.println("livro armazenado, voltando ao menu princial");
                            break;
                        case 2:
                            System.out.println("Voltando ao menu principal");
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + option);

                    }


                } catch (Exception e) {
                    throw new RuntimeException(e.getMessage());
                }

                condition = false;
            }

        } else {
            System.out.println("Livro / Autor não encontrado no banco de dados.");
        }
    }

    private void saveBookSearch() {
        DataResponseApi dados = getBookByTilteOrAuthor();
        Book book = new Book(dados);
        repository.save(book);


    }


    private DataResponseApi getBookByTilteOrAuthor() {
        System.out.println("Digite o titulo / autor do livro desejado: ");
        var bookTypeByUser = scanner.nextLine().replace(" ", "%20");
        var adressWithSearch = endereco + bookTypeByUser;
        var json = consumo.ObterDados(adressWithSearch);

        return converteDados.obterDados(json, DataResponseApi.class);
    }


}
