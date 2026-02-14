package br.com.alura.screensound.principal;

import java.util.Optional;
import java.util.Scanner;

import java.util.List;

import br.com.alura.screensound.model.Artista;
import br.com.alura.screensound.model.GeneroMusical;
import br.com.alura.screensound.model.Musica;
import br.com.alura.screensound.repository.ArtistaRepository;

public class Principal {

    private Scanner entrada = new Scanner(System.in);
    private final ArtistaRepository repositorio;

    public Principal(ArtistaRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    \n⁑⁂⁕⁂⁕ SCREEN SOUND ⁕⁂⁕⁂⁑
                    1. Cadastrar Novo Artista
                    2. Cadastrar Nova Música
                    3. Listar Músicas Cadastradas
                    4. Listar Artistas
                    5. Buscar Músicas por Artista
                    6. Pesquisar Dados Sobre Um Artista

                    0. Sair
                    """;

            System.out.print(menu);
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("Nos vemos em breve! Encerrando a aplicação...");
                    break;
                case 1:
                    System.out.println("Digite o nome do artista a cadastrar: ");
                    String artista = entrada.nextLine();
                    cadastrarArtista(artista);
                    System.out.println("Artista cadastrado com sucesso!");
                    break;
                case 2: //AQUI
                    System.out.println("Me diga o artista da música a cadastrar: ");
                    String autorMusica = entrada.nextLine();
                    System.out.println("Digite o nome da música a cadastrar: ");
                    String tituloMusica = entrada.nextLine();
                    System.out.println("Informe o gênero musical: ");
                    String genero = entrada.nextLine();
                    GeneroMusical generoMusica = GeneroMusical.valueOf(genero.toUpperCase());
                    cadastrarMusica(autorMusica, tituloMusica, generoMusica);
                    break;
                case 3: 
                    System.out.println("Suas músicas atuais:");
                    listarMusicas();
                    break;
                case 4:
                    System.out.println("Seus artistas favoritos:");
                    listarArtistas();
                    break;
                case 5:
                    System.out.println("Digite o nome do artista desejado: ");
                    String artistaBusca = entrada.nextLine();
                    buscarMusicaPorArtista(artistaBusca);
                    break;
                case 6: 
                    System.out.println("Digite o artista que deseja pesquisar: ");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
    }

    private void cadastrarArtista(String artista) {
        Artista novoArtista = new Artista(artista);
        repositorio.save(novoArtista);
    }


    //CORRIGIR ELSE
    private void cadastrarMusica(String autorMusica, String titulo, GeneroMusical generoMusical) {
        Optional<Artista> artista =
            repositorio.findByNomeContainingIgnoreCase(autorMusica);

        if (artista.isPresent()) {
            Musica novaMusica = new Musica(titulo, generoMusical);
            novaMusica.setArtista(artista.get());

            artista.get().getMusicas().add(novaMusica);
            repositorio.save(artista.get());
        } else {
            System.out.println("Artista não previamente cadastrado. Falha ao incluir música.");
        }
    }

    //corrigir tb
    private void listarMusicas() {
        List<Artista> artistas = repositorio.findAll();
        artistas.forEach(System.out::println);
    }

    private void buscarMusicaPorArtista(String artista) {
    }

     private void listarArtistas() {
       
    }
    
}
