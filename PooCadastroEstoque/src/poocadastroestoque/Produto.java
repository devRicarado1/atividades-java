package poocadastroestoque;

import java.util.Scanner;

class Produto {

    Scanner scanner = new Scanner(System.in);

    String nome;
    double preco;
    int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    void exibirInformacoes() {
        System.out.println("Nome do Produto: " + nome);
        System.out.println("Preco do Produto: " + preco);
        System.out.println("Quantidade em Estoque: " + quantidade);
    }

    void reporEstoque() {
        System.out.print("Digite a quantidade a ser adicionada ao estoque de " + nome + ": ");
        int reposicao = scanner.nextInt();
        if (reposicao > 0) {
            quantidade += reposicao;
            System.out.println("Estoque atualizado! Nova quantidade: " + quantidade);
        } else {
            System.out.println("Quantidade inválida. A reposição deve ser maior que zero.");
        }
    }

    void vender() {
        System.out.print("Digite a quantidade que deseja comprar de " + nome + ": ");
        int quantidadeVenda = scanner.nextInt();
        
        if (quantidadeVenda <= 0) {
            System.out.println("Quantidade Negatica para Venda");
        } else if (quantidadeVenda <= quantidade) {
            quantidade -= quantidadeVenda;
            double total = quantidadeVenda * preco;
            System.out.println("Venda realizada com sucesso!");
            System.out.println("Total: R$ " + total);
            System.out.println("Quantidade restante em estoque: " + quantidade);
        } else {
            System.out.println("Estoque Insuficiente. Apenas " + quantidade + " unidades disponiveis.");
        }
    }
}
