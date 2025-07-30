package one.Literalura.repository;

import one.Literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryAuthor extends JpaRepository<Autor, Long> {
}
