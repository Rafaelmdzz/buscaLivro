package br.com.rafael.livro.models.clas;

import br.com.rafael.livro.models.records.AutorDTO;
import br.com.rafael.livro.models.records.LivrosDTO;
import jakarta.persistence.*;

import java.util.List;
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private List<LivrosDTO> livrosAutor;

    public Long getId() {
        return id;
    }

    public List<LivrosDTO> getLivrosAutor() {
        return livrosAutor;
    }

    public Autor() {
    }

    public Autor(AutorDTO autor) {
        this.livrosAutor = autor.livros();
    }
}
