package br.com.rafael.livro.models.records;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivrosDTO(
        @JsonAlias("id") String id,
        @JsonAlias("volumeInfo")VolumeInfoDTO volumeInfo
) {
}
