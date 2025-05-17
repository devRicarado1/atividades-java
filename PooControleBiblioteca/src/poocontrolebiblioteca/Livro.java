package poocontrolebiblioteca;

import java.util.Scanner;

public class Livro {

    Scanner scanner = new Scanner(System.in);

    String tituloLivro;
    String autorLivro;
    String anoPublicacao;
    int numeroExemplares;

    public Livro(String tituloLivro, String autorLivro, String anoPublicacao, int numeroExemplares) {
        this.tituloLivro = tituloLivro;
        this.autorLivro = autorLivro;
        this.anoPublicacao = anoPublicacao;
        this.numeroExemplares = numeroExemplares;
    }

    void exibirInformacoes() {
        System.out.println("===================================");
        System.out.println("         Livro Cadastrado        ");
        System.out.println("===================================");
        System.out.println("Titulo:            " + tituloLivro);
        System.out.println("Autor:             " + autorLivro);
        System.out.println("Ano de Publicacao: " + anoPublicacao);
        System.out.println("Exemplares:        " + numeroExemplares);
        System.out.println("===================================\n");
    }

    void emprestarLivro() {
        System.out.println("");
        if (numeroExemplares > 0) {
            numeroExemplares --;
            System.out.println("Livro Emprestado com Sucesso!");
        } else {
            System.out.println("Nao ha exemplares disponiveis para emprestimo.");
        }
    }

    void devolverLivro() {
        numeroExemplares ++;
        System.out.println("Livro Devolvido com Sucesso!");
    }

}
