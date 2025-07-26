package one.Literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    public DataResponseApi Book (DataResponseApi responseApi){
        this.title = responseApi.results().getFirst().titulo();
        this.authors = responseApi.results().getFirst().autores().toString();
        this.languages = responseApi.results().getFirst().idiomas().toString();
        this.downloadCount = responseApi.results().getFirst().downloads();



        return


    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nAutor: " + authors +
                "\nIdioma: " + languages +
                "\nDownloads: " + downloadCount + "\n";
    }
 }