package one.Literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    private String nomne;

    public List<Book> getLivros() {
        return livros;
    }

    public void setLivros(List<Book> livros) {
        this.livros = livros;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public String getNomne() {
        return nomne;
    }

    public void setNomne(String nomne) {
        this.nomne = nomne;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @ManyToMany
    private List<Book> livros;

    public Autor (  ){


    }

}
