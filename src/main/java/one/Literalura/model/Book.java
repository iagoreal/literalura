package one.Literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    public Integer getDownload_count() {
        return downloadCount;
    }

    public void setDownload_count(Integer downloadCount) {
        this.downloadCount = downloadCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    private String title;
    private String authors;
    private String languages;
    private Integer downloadCount;


    public Book(){    }

    public Book (DataResponseApi responseApi){

            this.title = responseApi.results().getFirst().titulo();
            this.authors = responseApi.results().getFirst().autores().stream().map(
                    a -> a.nomne() + " (" + a.anoNascimento() + "-" + a.anoFalecimento() + ")").collect(Collectors.joining(", "));
            this.languages = String.join(", ", responseApi.results().getFirst().idiomas());
            this.downloadCount = responseApi.results().getFirst().downloads();



    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nAutor: " + authors +
                "\nIdioma: " + languages +
                "\nDownloads: " + downloadCount + "\n";
    }
 }