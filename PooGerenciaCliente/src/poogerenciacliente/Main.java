package poogerenciacliente;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean repeticao = true;
        int opcao = 0;

        Cliente[] clientes = null;
        int quantVetor = 0;

        while (repeticao) {

            System.out.println("---------------------------------");
            System.out.println("MENU GERENCIAMENTO DE CLEINTE:");
            System.out.println("1 - Cadastra Novo cliente: ");
            System.out.println("2 - Clientes Cadastrados: ");
            System.out.println("3 - Editar Cliente: ");
            System.out.println("4 - Remove Cliente: ");
            System.out.println("5 - Sair do sistema");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    System.out.println("Opcao Selecionada: Cadastra Cliente");
                    System.out.println("Digite quantidade de Clientes que deseja cadastra: ");
                    quantVetor = scanner.nextInt();
                    clientes = new Cliente[quantVetor];

                    for (int i = 0; i < quantVetor; i++) {
                        clientes[i] = new Cliente("", "", "");
                        clientes[i].cadastroCliente();
                    }

                    break;
                case 2:
                    System.out.println("Opcao Selecionada: visualizar Clientes cadastrados");

                    if (clientes == null || quantVetor == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("Nenhum Cliente Cadastrado");
                        System.out.println("---------------------------------");
                    } else {
                        System.out.println("Clientes Cadastrados: ");
                        for (int i = 0; i < quantVetor; i++) {
                            clientes[i].clientesCadastrados(i + 1);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Opcao Selecionada: Editar Cliente");
                    if (clientes == null || quantVetor == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("Nenhum Cliente Cadastrado");

                    } else {

                        for (int i = 0; i < quantVetor; i++) {
                            clientes[i].clientesCadastrados(i + 1);
                        }

                        System.out.println("Digite o numero do Cliente para editar: ");
                        int numeroCliente = scanner.nextInt();

                        if (numeroCliente < 1 || numeroCliente > quantVetor) {
                            System.out.println("Numero do Cliente Invalido");
                        } else {
                            clientes[numeroCliente - 1].editarCliente();
                        }
                    }

                    break;
                case 4:
                    System.out.println("Opcao Selecionada: Remove Cliente");

                    if (clientes == null || quantVetor == 0) {
                        System.out.println("---------------------------------");
                        System.out.println("Nenhum Cliente Cadastrado");

                    } else {

                        for (int i = 0; i < quantVetor; i++) {
                            clientes[i].clientesCadastrados(i + 1);
                        }

                        System.out.println("Digite o ID do Cliente para excluir: ");
                        int numeroCliente = scanner.nextInt();

                        if (numeroCliente < 1 || numeroCliente > quantVetor) {
                            System.out.println("Numero do Cliente Invalido");
                        } else {
                            Cliente[] atualizarVetor = new Cliente[quantVetor - 1];
                            
                            for(int i = 0, j=0; i < quantVetor; i++){
                                if(i != numeroCliente - 1) {
                                    atualizarVetor[j++] = clientes[i];
                                }
                            }
                            clientes = atualizarVetor;
                            quantVetor--;
                            
                            System.out.println("Cliente Removido com Sucesso!");
                        }
                    }
                    
                    
                    break;
                case 5:
                    System.out.println("Encerrando Sistema!");
                    repeticao = false;
            }
        }

    }

}
