package one.Literalura.model;
import jakarta.persistence.*;

import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authors;
    private String languages;
    private Integer downloadCount;
    @ManyToOne(cascade = CascadeType.ALL)
    private Autor autor;


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




    public Book(){    }

    public Book (DataResponseApi responseApi){
            this.title = responseApi.results().getFirst().titulo();
            this.authors = responseApi.results().getFirst().autores().stream().map(
                    a -> a.nome() + " (" + a.anoNascimento() + "-" + a.anoFalecimento() + ")").collect(Collectors.joining(", "));
            this.languages = String.join(", ", responseApi.results().getFirst().idiomas());
            this.downloadCount = responseApi.results().getFirst().downloads();

            if(responseApi.results().getFirst().autores() != null && !responseApi.results().getFirst().autores().isEmpty()){
                var autorData = responseApi.results().getFirst().autores();
                Autor autor = new Autor();
                autor.setNome(autorData.getFirst().nome());
                autor.setAnoNascimento(autorData.getFirst().anoNascimento());
                autor.setAnoFalecimento(autorData.getFirst().anoFalecimento());
                this.autor = autor;
            }
    }

    @Override
    public String toString() {
        return "Título: " + title +
                "\nAutor: " + authors +
                "\nIdioma: " + languages +
                "\nDownloads: " + downloadCount + "\n";
    }
 }