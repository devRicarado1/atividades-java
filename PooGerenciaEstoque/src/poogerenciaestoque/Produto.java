package poogerenciaestoque;

import java.util.Scanner;

public class Produto {

    Scanner scanner = new Scanner(System.in);

    String nomeProduto;
    double precoProduto;
    int quantItens;

    public Produto(String nomeProduto, double precoProduto, int quantItens) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantItens = quantItens;
    }

    void exibirInformacoes() {
        System.out.println("Produto: " + nomeProduto + " Preco do Produto R$: " + precoProduto + " Quantidade em Estoque: " + quantItens);
    }

    void reporEstoque() {
        System.out.println("Informe a quantidade do produto");
        int novaQuantidade = scanner.nextInt();
        quantItens += novaQuantidade;

        System.out.println("Deseja alterar o Preco do produto? ");
        System.out.println("1 - SIM");
        System.out.println("2 - NAO");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o novo Valor do Produto: ");
                double novoValor = scanner.nextDouble();
                precoProduto = novoValor;
                System.out.println("Preco do Produto Alterado com Sucesso! ");
                break;
                
            case 2:
                System.out.println("Preco Mantido");
                break;
            default:
                System.out.println("Opcao Invalida, Tente Novamente");
        }

        System.out.println("Reposição concluída. Estoque atual: " + quantItens);
    }

    void vender() {

        System.out.println("Informe a quantidade que deseja vender: ");
        int quantVenda = scanner.nextInt();
        
        if (quantVenda <= quantItens) {
            quantItens -= quantVenda;
            System.out.println("Venda Realizada com Sucesso!");
            System.out.println("Estoque restante: " + quantItens);
        } else {
            System.out.println("Estoque Insuficiente. Quantidade disponivel: " + quantItens);
        }
    }
}
