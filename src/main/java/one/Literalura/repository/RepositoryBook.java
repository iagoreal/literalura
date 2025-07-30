package one.Literalura.repository;

import one.Literalura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryBook extends JpaRepository<Book, Long> {
}
