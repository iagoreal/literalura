package one.Literalura.dto;

import one.Literalura.model.DadosAutor;

import java.util.List;

public record BookDTO(
        String titulo,
        List<DadosAutor> autores,
        List<String> idiomas,
        Integer downloads
) {

}
