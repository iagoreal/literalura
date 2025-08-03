package one.Literalura.repository;

import one.Literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryBook extends JpaRepository<Book, Long> {

    List<Book> findByLanguages(String languages);

}
