package poogerenciaestoque;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        String nomeProduto;
        double precoProduto = 0;
        int quantItens = 0;

        boolean loop = true; // Para deixa o while infinito

        while (loop) {
            System.out.println("MENU - GERENCIAMENTO DE ESTOQUE");
            System.out.println("1 - CADASTRAR PRODUTO");
            System.out.println("2 - EXIBIR PRODUTOS");
            System.out.println("3 - REPOR ESTOQUE");
            System.out.println("4 - REALIZAR VENDA");
            System.out.println("5 - SAIR");
            System.out.println("Digite uma opcao: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Opcao Seleciona: Cadastra Produto");
                    System.out.println("Digite Quantos Produtos Deseja Cadastra: ");
                    int quantVetor = scanner.nextInt(); // Quantidade de Itens Para Adiciona
                    scanner.nextLine(); // Tira a quebra de linha do nextInt

                    for (int i = 0; i < quantVetor; i++) {
                        System.out.println("Digite o nome do Produto: ");
                        nomeProduto = scanner.nextLine();

                        System.out.println("Digite o Preco: ");
                        precoProduto = scanner.nextDouble();

                        System.out.println("Digite a quantidade de Itens: ");
                        quantItens = scanner.nextInt();
                        scanner.nextLine(); // Tira a quebra de linha do nextInt

                        Produto adicionaProduto = new Produto(nomeProduto, precoProduto, quantItens);
                        produtos.add(adicionaProduto); // produto e o ArrayList

                        System.out.println("Produto adicionado com sucesso!");
                    }

                    break;
                case 2:
                    System.out.println("Opcao Selecionada: Exibir Produtos");

                    for (Produto produto : produtos) {
                        produto.exibirInformacoes();
                        System.out.println("----------------");
                    }

                    break;
                case 3:
                    System.out.println("Opcao Selecionada: Repor Estoque");
                    System.out.println("Produtos Disponiveis;");
                    
                    for(int i = 0; i < produtos.size(); i++) {
                        System.out.println("[" + i + "]" + produtos.get(i).nomeProduto);
                    }
                    
                    System.out.println("Digite o numero do produto para repor: ");
                    int indiceReposicao = scanner.nextInt();
                    
                    if (indiceReposicao >= 0 && indiceReposicao < produtos.size()) {
                        produtos.get(indiceReposicao).reporEstoque();
                    } else {
                        System.out.println("Indice Invalido");
                    }                    
                    break;

                case 4:
                    System.out.println("Opcao Selecionada: Realizar Venda");
                    
                    if(produtos.isEmpty()) {
                        System.out.println("Nenhum Produto Cadastrado.");
                    } else {
                        for(int i = 0; i < produtos.size(); i++) {
                            System.out.println("[" + i + "] " + produtos.get(i).nomeProduto);
                        }
                        
                        System.out.println("Digite o numero do produto que deseja vender: ");
                        int indiceVenda = scanner.nextInt();
                        
                        if(indiceVenda >= 0 && indiceVenda < produtos.size()) {
                            produtos.get(indiceVenda).vender();
                        } else {
                            System.out.println("Indice Invalido.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Opcao Selecionada: Sair do Sistema");
                    loop = false;
                    break;
            }
        }

    }

}
