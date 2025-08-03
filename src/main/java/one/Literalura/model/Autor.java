package one.Literalura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "autores")
public class Autor {

    private String nome;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer anoNascimento;
    private Integer anoFalecimento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Book> livros;


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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Book> getLivros() {
        return livros;
    }

    public void setLivros(List<Book> livros) {
        this.livros = livros;
    }



    @Override
    public String toString() {
        return "\n" +
                "------------------------- \n" + id +
                "\n nome:'" + nome + '\'' +
                "\n Ano de Nascimento:" + anoNascimento +
                "\n Ano de Falecimento:" + anoFalecimento;
    }

}
