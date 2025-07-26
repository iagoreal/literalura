package one.Literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataResponseApi(
        @JsonAlias("count") Integer totalBooks,
        @JsonAlias("next") String nextPage,
        @JsonAlias("previous") String previusPage,
        @JsonAlias("results") List<DataBook> results
        ) {
}
