package br.com.rafael.livro.models.clas;

import br.com.rafael.livro.models.records.ImagemCapaDTO;
import br.com.rafael.livro.models.records.LivrosDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_banco;

    private String id_api;
    private String titulo;
    private String editora;
    private List<String> autores;
    private String lancamento;
    private String descricao;
    private Integer paginas;
    @ElementCollection
    private List<String> genero;
    private String capa;

    public Long getId_banco() {return id_banco;}

    public String getId_api() {return id_api;}

    public String getTitulo() {
        return titulo;
    }

    public String getEditora() {
        return editora;
    }

    public List<String> getAutores() {
        return autores;
    }

    public String getLancamento() {
        return lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public List<String> getGenero() {
        return genero;
    }

    public String getCapa() {
        return capa;
    }

    public Livros(LivrosDTO livrosDTO) {
        this.id_api = livrosDTO.id();
        this.titulo = livrosDTO.volumeInfo().titulo();
        this.editora = livrosDTO.volumeInfo().editora();
        this.lancamento = livrosDTO.volumeInfo().lancamento();
        this.descricao = livrosDTO.volumeInfo().descricao();
        this.paginas = livrosDTO.volumeInfo().paginas();
        this.genero = livrosDTO.volumeInfo().genero();
        this.capa = livrosDTO.volumeInfo().capa().urlCapa();
    }

    public Livros() {
    }

    @Override
    public String toString() {
        return "Livros{" +
                "id='" + id_api + '\'' +
                ", titulo='" + titulo + '\'' +
                ", editora='" + editora + '\'' +
                ", autores=" + autores +
                ", lancamento='" + lancamento + '\'' +
                ", paginas=" + paginas +
                ", genero='" + genero + '\'' +
                ", capa=" + capa +
                '}';
    }
}
