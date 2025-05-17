package poocontrolebiblioteca;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Livro> livros = new ArrayList<>();

        boolean infinito = true; // Para o Laco de repeticao se infinito
        int opcao = 0; // Para Swhitch

        String tituloLivro;
        String autorLivro;
        String anoPublicacao;
        int numeroExemplares;

        while (infinito) {
            System.out.println("MENU - CONTROLE BIBLIOTECA");
            System.out.println("1 - CADASTRA LIVRO");
            System.out.println("2 - LIVROS DISPONIVEIS");
            System.out.println("3 - BUSCAR LIVRO");
            System.out.println("4 - REALIZAR EMPRESTIMO LIVRO");
            System.out.println("5 - REALIZAR DEVOLUCAO LIVRO");
            System.out.println("6 - SAIR DO SISTEMA");
            System.out.println("Digite uma Opcao: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opcao Selecionada: Cadastra Livro");
                    System.out.println("Digite Quantos Livros Deseja Cadastra: ");
                    int indiceLivro = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < indiceLivro; i++) {
                        System.out.println("Digite o Titulo do Livro: ");
                        tituloLivro = scanner.nextLine();

                        System.out.println("Digite o Autor do Livro: ");
                        autorLivro = scanner.nextLine();

                        System.out.println("Digite o Ano de Publicao do Livro: ");
                        anoPublicacao = scanner.nextLine();

                        System.out.println("Digite a Quantidade de Exemplares do Livro: ");
                        numeroExemplares = scanner.nextInt();

                        scanner.nextLine();

                        Livro adicionaLivro = new Livro(tituloLivro, autorLivro, anoPublicacao, numeroExemplares);
                        livros.add(adicionaLivro);
                    }

                    break;
                case 2:
                    System.out.println("Opcao Selecionada: Exibir Livros Cadastrados");

                    if (livros.size() <= 0) {
                        System.out.println("=====================================");
                        System.out.println("         Nenhum Livro Cadastrado     ");
                        System.out.println("=====================================");
                        System.out.println("   Parece que a biblioteca esta vazia.");
                        System.out.println("    Cadastre um livro para comecar!    ");
                        System.out.println("=====================================");
                    } else {
                        for (Livro lacoRepeticao : livros) {
                            lacoRepeticao.exibirInformacoes();
                        }
                    }

                    break;
                case 3:
                    System.out.println("Opcao Selecionada: Bucar Livro");
                    System.out.println("Digite o Titulo ou Autor do Livro: ");
                    String buscarLivro = scanner.nextLine();

                    int indice = -1; // Valor Padrão caso não seja encontrado.                    

                    for (int i = 0; i < livros.size(); i++) {
                        // Verifica se o título ou o autor do livro corresponde ao que o usuário digitou
                        if (livros.get(i).tituloLivro.equalsIgnoreCase(buscarLivro) || livros.get(i).autorLivro.equalsIgnoreCase(buscarLivro)) {
                            indice = i;
                            break;
                        }
                    }
                    if (indice != -1) {
                        livros.get(indice).exibirInformacoes();
                    } else {
                        System.out.println("Livro Não Encontrado.");

                        break;
                    }
                    break;
                case 4:
                    System.out.println("Opcao Selecionada: Realizar Emprestimo Livro");

                    if (livros.isEmpty()) {
                        System.out.println("Nenhum Livro Cadastrado.");
                    } else {
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println("[" + i + "] " + livros.get(i).tituloLivro);
                        }
                        System.out.println("Digite o numero do livro que deseja emprestar: ");
                        int indiceEmprestimo = scanner.nextInt();

                        if (indiceEmprestimo >= 0 && indiceEmprestimo < livros.size()) {
                            livros.get(indiceEmprestimo).emprestarLivro();
                        } else {
                            System.out.println("Indice Invalido");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Opcao Selecionada: Realizar Devolucao Livro");
                    if (livros.isEmpty()) {
                        System.out.println("Nenhum Livro Cadastrado");
                    } else {
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println("[" + i + "] " + livros.get(i).tituloLivro);
                        }
                        System.out.println("Digite o número do livro que deseja devolver: ");
                        int indiceDevolucao = scanner.nextInt();

                        if (indiceDevolucao >= 0 && indiceDevolucao < livros.size()) {
                            livros.get(indiceDevolucao).devolverLivro();
                        } else {
                            System.out.println("Indice Invalido");
                        }
                    }
                    break;
                case 6:
                    System.out.println("Opcao Selecionada: Sair do Sistema: ");
                    infinito = false;
                    break;

            }

            System.out.println("");
        }
    }

}
