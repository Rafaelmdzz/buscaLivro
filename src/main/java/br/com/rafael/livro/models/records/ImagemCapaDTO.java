package br.com.rafael.livro.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record ImagemCapaDTO(
        @JsonAlias("thumbnail") String urlCapa
) {
}