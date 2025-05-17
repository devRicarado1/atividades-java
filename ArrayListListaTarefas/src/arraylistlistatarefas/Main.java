package arraylistlistatarefas;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Etapa 1: Adicionar e Listar Tarefas
        // Vamos fazer o seguinte: Criar um menu com 4 opções:
        // Adicionar Tarefa
        // Listar Tarefas
        // Remover Tarefa
        // Sair 
        Scanner scanner = new Scanner(System.in);

        // Array que vai adicionar Tarefas do tipo String.
        ArrayList<String> tarefas = new ArrayList<>();

        boolean loop = true; // Laço Repetilçao Infinito

        while (loop) {
            System.out.println("MENU LISTA DE ATIVIDADES");
            System.out.println("[1] - ADICIONAR TAREFA");
            System.out.println("[2] - LISTA TAREFAS");
            System.out.println("[3] - REMOVE TAFEFA");
            System.out.println("[4] - SAIR");
            System.out.println("Digite uma Opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Opcao Selecionada: Adicionar Tarefa");

                    System.out.println("Digite Quantas Tarefas deseja Adiciona: ");
                    int quantidadeTarefa = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < quantidadeTarefa; i++) {
                        System.out.println("Digite o Nome da Tarefa: ");
                        String nomeTarefa = scanner.nextLine();
                        tarefas.add(nomeTarefa);
                        System.out.println("Tarefa Adicionada com Sucesso!");
                    }
                    break;

                case 2:
                    System.out.println("Opcao Selecionada: Lista Tarefas");

                    // ".isEmpty()" Verificar se o Numero e Vazio antes de tentar remover
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma Tarefa Cadastrada");
                    } else {
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println((i) + " - " + tarefas.get(i));
                        }
                    }
                    break;

                case 3:
                    
                    // ".isEmpty()" Verificar se o Numero e Vazio antes de tentar remover
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma Tarefa Cadastrada");
                    } else {
                         // Exibe todas as tarefas cadastradas com seus respectivos índices
                        for (int i = 0; i < tarefas.size(); i++) {
                            System.out.println("Tarefa: [ " + i + " ] = " + tarefas.get(i));
                        }
                    }
                    System.out.println("Digite o Numero do Indice que deseja Remove: ");
                    int removeTarefa = scanner.nextInt();

                    if (removeTarefa >= 0 && removeTarefa < tarefas.size()) {
                        // Remove a tarefa e armazena o nome da tarefa removida para exibir ao usuário
                        String tarefaRemovida = tarefas.remove(removeTarefa);
                        System.out.println("Tarefa \"" + tarefaRemovida + "\" removida com Sucesso");
                    } else {
                        // Caso o índice seja inválido (menor que 0 ou maior que o último índice da lista)
                         System.out.println("Indice inválido. Nenhuma tarefa foi removida.");
                    }           

                    break;

                case 4:
                    System.out.println("Opcao Selecionada: Sair");
                    loop = false;
                    break;

                default:
                    System.out.println("Opcao Invalida. Tente Novamente");
            }

        }
    }

}
