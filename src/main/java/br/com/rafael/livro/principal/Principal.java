package br.com.rafael.livro.principal;

import br.com.rafael.livro.models.clas.Livros;
import br.com.rafael.livro.models.records.AutorDTO;
import br.com.rafael.livro.models.records.LivrosDTO;
import br.com.rafael.livro.service.ConsumoApi;
import br.com.rafael.livro.service.ConvertDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConsumoApi consumo = new ConsumoApi();
    private ConvertDados conversor = new ConvertDados();

    private final String ENDERECO = "https://www.googleapis.com/books/v1/volumes?q=";
    private final String API_KEY = "&key=AIzaSyAlwLWRAnGOQmHxSBVDPkezG2nrbCO4e_I";

    public void exibirmenu(){
        var json = " ";

        System.out.println("bem vindo a busca livros");
        int escolha = -1;
        while ( escolha != 0){
            System.out.printf("""
                    Oque gostaria de fazer?
                    1- Pesquisar um livro
                    2- Ver livros guardados
                    3- Sair
                    """);
            escolha = scanner.nextInt();

            if (escolha >= 1 && escolha <= 3){
                switch (escolha){
                    case 1 :
                        System.out.printf("""
                                Gostaria de pesquisar:
                                1- Livro
                                2- Autor
                                """);
                        int escPesquisa = scanner.nextInt();

                        if (escPesquisa == 1){
                            System.out.print("digite o nome do livro: ");
                            String livroPesquisa = scanner.nextLine();
                            livroPesquisa = scanner.nextLine();
                            json = consumo.obterDados(ENDERECO+ livroPesquisa.replace(" ", "+") + API_KEY);
                            List<LivrosDTO> respostaApi = conversor.obterListaDados(json, LivrosDTO.class);

                            for (int i = 0; i < respostaApi.size(); i++) {
                                LivrosDTO livro = respostaApi.get(i);
                                System.out.printf("""
                                        
                                        Resposta numero %d
                                        
                                        Nome: %s
                                        Editora: %s
                                        Autor: %s
                                        Numero de paginas: %d
                                        """, i + 1, livro.volumeInfo().titulo(), livro.volumeInfo().editora(), livro.volumeInfo().autores(), livro.volumeInfo().paginas());
                            }

                            System.out.printf("""
                                    Salvar algum livro?
                                    0- não salvar nenhum
                                    se quiser salvar algum digite o numero do livro
                                    """);
                            int salvar = scanner.nextInt();
                            if (salvar != 0){

                            }
                        } else if (escolha == 2) {
                            System.out.print("digite o nome do livro: ");
                            String autorPesquisa = scanner.nextLine();
                            json = consumo.obterDados(ENDERECO + "q=inauthor:" + autorPesquisa.replace(" ", "+") + API_KEY);
                            AutorDTO autor = conversor.obterDados(json, AutorDTO.class);
                            System.out.println("Autor:" + autorPesquisa);
                            autor.livros().forEach(l -> System.out.printf("""
                                    
                                    Resposta numero %d
                                        
                                        Nome: %s
                                        Editora: %s
                                        Autor: %s
                                        Numero de paginas: %d
                                    """, l.volumeInfo().titulo(),l.volumeInfo().editora(), l.volumeInfo().autores(), l.volumeInfo().paginas()));
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                }
            }
        }
    }

}
