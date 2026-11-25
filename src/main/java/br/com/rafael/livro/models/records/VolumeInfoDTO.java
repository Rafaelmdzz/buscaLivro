package br.com.rafael.livro.models.records;

import br.com.rafael.livro.models.clas.Autor;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record VolumeInfoDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("publisher") String editora,
        @JsonAlias("authors") List<String> autores,
        @JsonAlias("publishedDate") String lancamento,
        @JsonAlias("description") String descricao,
        @JsonAlias("pageCount") Integer paginas,
        @JsonAlias("categories") List<String> genero,
        @JsonAlias("imageLinks") ImagemCapaDTO capa
) {
}
