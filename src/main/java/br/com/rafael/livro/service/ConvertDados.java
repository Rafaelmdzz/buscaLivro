package br.com.rafael.livro.service;

import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

public class ConvertDados implements IConvertDados{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return mapper.readValue(json, classe);
    }

    @Override
    public <T> List<T> obterListaDados(String json, Class<T> classe) {

        JsonNode raiz = mapper.readTree(json);

        JsonNode items = raiz.get("items");

        return mapper.convertValue(
                items,
                mapper.getTypeFactory()
                        .constructCollectionType(List.class, classe)
        );
    }
}
