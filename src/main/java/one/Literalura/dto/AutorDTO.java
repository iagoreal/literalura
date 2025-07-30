package one.Literalura.dto;

import com.fasterxml.jackson.annotation.JsonAlias;

public record AutorDTO(
        String nomne,
        Integer anoNascimento,
        Integer anoFalecimento
) {
}
