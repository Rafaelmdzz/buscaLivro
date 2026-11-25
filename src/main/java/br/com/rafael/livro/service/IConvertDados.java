package br.com.rafael.livro.service;

import java.util.List;

public interface IConvertDados {
    <T> T  obterDados(String json, Class<T> classe);
    <T> List<T> obterListaDados(String json, Class<T> classe);
}
