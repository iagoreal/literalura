package one.Literalura.principal;

import one.Literalura.model.Book;
import one.Literalura.model.DataBook;
import one.Literalura.model.DataResponseApi;
import one.Literalura.service.ConsumoApi;
import one.Literalura.service.ConverteDados;

import java.util.Scanner;

public class Main {
    private ConsumoApi consumo = new ConsumoApi();
    String endereco = "https://gutendex.com/books/?search=";
    private ConverteDados converteDados = new ConverteDados();

    private final Scanner scanner = new Scanner(System.in);
    int chose;


    boolean condition = true;
    public void showMenu() {


        while(condition){
            var menu = """
                    1 - Buscar livro
                    2 -
                    3 - 
                    4 - 
                    5 - 
                    6 - 
                    7 - 
                    8 - 
                    9 - 
                    10 - 
                    11 -  
                                    
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
                    case 1:
                        searchByTitle();
                        break;
                    case 2:

                        break;
                    case 3:
                        System.out.println("Fechando programa...");
                        condition = false;
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


    private DataResponseApi searchByTitle() {
        System.out.println("Digite o titulo do livro que deseja: ");
        var bookTypeByUser = scanner.nextLine().replace(" ", "%20");
        var adressWithSearch = endereco + bookTypeByUser;
        var json = consumo.ObterDados(adressWithSearch);
        System.out.println(json);
        DataResponseApi dataBook = converteDados.obterDados(json, DataResponseApi.class);
        System.out.println(dataBook);
        return dataBook;


    }


}
