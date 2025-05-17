package poocadastroestoque;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Produto Produto1 = new Produto("Feijão", 8.67, 15);
        Produto Produto2 = new Produto("Arroz", 5.74, 10);
        Produto Produto3 = new Produto("Macarrao", 3.60, 2);
        Produto Produto4 = new Produto("Acucar", 2.60, 24);
        Produto Produto5 = new Produto("Sal", 1.60, 0);

        Produto[] listaProdutos = {Produto1, Produto2, Produto3, Produto4, Produto5};

        int opcao = 0;
        boolean executando = true; // Laço de Repetição infinito no no Menu

        while (executando) {
            System.out.println("Menu Supermercado");
            System.out.println("1 - Exibir Lista Produtos");
            System.out.println("2 - Repor Estoque Produtos");
            System.out.println("3 - Vende Produto");
            System.out.println("4 - Encerrar Sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            System.out.println("---------------------------------");

            switch (opcao) {

                case 1:
                    for (int i = 0; i < listaProdutos.length; i++) {
                        System.out.println("[" + i + "] " + listaProdutos[i].nome);
                        listaProdutos[i].exibirInformacoes();
                        System.out.println("---------------------------------");
                    }
                    break;

                case 2:
                    System.out.println("Escolha o número do produto para repor:");               
                    for (int i = 0; i < listaProdutos.length; i++) {
                        System.out.println("[" + i + "] " + listaProdutos[i].nome);
                    }
                    
                    int indiceReposicao = scanner.nextInt();
                    
                    if (indiceReposicao >= 0 && indiceReposicao < listaProdutos.length) {
                        listaProdutos[indiceReposicao].reporEstoque();
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;

                case 3:
                    System.out.println("Escolha o número do produto para vender:");
                    for (int i = 0; i < listaProdutos.length; i++) {
                        System.out.println("[" + i + "] " + listaProdutos[i].nome);
                    }
                    int indiceVenda = scanner.nextInt();
                    if (indiceVenda >= 0 && indiceVenda < listaProdutos.length) {
                        listaProdutos[indiceVenda].vender();
                    } else {
                        System.out.println("Produto inválido.");
                    }
                    break;

                case 4:
                    System.out.println("Saindo do programa...");
                    executando = false;
                    break;

                default:
                    System.out.println("Opcao Invalida. Tente Novamente");
            }
        }
    }

}
