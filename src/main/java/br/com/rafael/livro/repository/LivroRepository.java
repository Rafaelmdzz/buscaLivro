package br.com.rafael.livro.repository;

import br.com.rafael.livro.models.clas.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livros, Long> {
}
