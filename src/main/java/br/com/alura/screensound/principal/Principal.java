package br.com.alura.screensound.principal;

import java.util.Scanner;

public class Principal {

    private Scanner entrada = new Scanner(System.in);

    public void exibeMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                    \n⁑⁂⁕⁂⁕ SCREEN SOUND ⁕⁂⁕⁂⁑
                    1. Cadastrar Novo Artista
                    2. Cadastrar Nova Música
                    3. Listar Músicas Cadastradas
                    4. Buscar Músicas por Artistas
                    5. Pesquisar Dados Sobre Um Artista

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
                case 2:
                    System.out.println("Digite o nome da música a cadastrar: ");
                    String musica = entrada.nextLine();
                    cadastrarMusica(musica);
                    System.out.println("Música cadastrada com sucesso!");
                case 3: 
                    System.out.println("Suas músicas atuais:");
                    listarMusicas();
                case 4:
                    System.out.println("Digite o nome do artista desejado: ");
                    String artistaBusca = entrada.nextLine();
                    buscarMusicaPorArtista();
                case 5: 
                    System.out.println("Digite o artista que deseja pesquisar: ");
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        }
    }

    private void buscarMusicaPorArtista() {
    }

    private void listarMusicas() {
       
    }

    private void cadastrarMusica(String musica) {
       
    }

    private void cadastrarArtista(String artista) {
        
    }
}
