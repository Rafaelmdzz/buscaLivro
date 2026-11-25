package br.com.rafael.livro.models.records;

import br.com.rafael.livro.models.clas.Livros;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record AutorDTO(
        @JsonAlias("volumeInfo") List<LivrosDTO> livros
        ) {
}
