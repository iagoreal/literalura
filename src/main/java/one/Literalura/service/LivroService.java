package one.Literalura.service;

import one.Literalura.model.Autor;
import one.Literalura.model.Book;
import one.Literalura.repository.RepositoryAuthor;
import one.Literalura.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;

public class LivroService {

    @Autowired
    private RepositoryBook repositoryBook;
    @Autowired
    private RepositoryAuthor repositoryAuthor;


    public Book saveBook (String titulo, String authors, String languages, Integer downloadCount){
        Autor autor = new Autor();
        autor.setNomne(authors);

        Autor saveAutor = repositoryAuthor.save(autor);

        Book book = new Book();
        book.setTitle(titulo);
        book.setAuthors(authors);
        book.setLanguages(languages);
        book.setDownload_count(downloadCount);

        return repositoryBook.save(book);

    }



}
