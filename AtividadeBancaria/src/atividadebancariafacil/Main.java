package atividadebancariafacil;

import java.util.Scanner;
import atividadebancariafacil.Cliente;
import java.util.ArrayList;
import java.util.List;

//  Objetivo: Criar um sistema simples de cadastro de contas bancárias que permita:
// Que o usuário crie uma conta bancária, informando: Nome do titular, Número da conta, Saldo inicial
// Guardar todas as contas criadas em uma estrutura (como uma lista) para consulta posterior.
// Permitir que o usuário deposite dinheiro em uma conta específica, informando: Número da conta, Valor a ser depositado
// Permitir consultar o saldo de uma conta, informando o número da conta.
// Criar um menu interativo no terminal, onde o usuário possa escolher o que deseja fazer (criar conta, depositar, consultar saldo, sair).
// Começei fazer a atividade dia 11/05/2025 as 17:45. Terminei as 20:40
// Novas Funcionalidades Nivel Intemrediario
// 1. Saque O usuário deve poder sacar um valor de uma conta existente. Validar se há saldo suficiente. Exibir mensagem de erro se o valor for maior que o saldo.
// 2. Transferência entre contas Permitir transferir um valor de uma conta para outra. Solicitar os dois números de conta: origem e destino.
// Validar: Se ambas as contas existem. Se a conta de origem tem saldo suficiente. Atualizar os saldos de ambas as contas.
// 3. Listar todas as contas Mostrar na tela: Número da conta, Nome do titular Saldo atual
// Começei fazer a atividade dia 12/05/2025 as 21:45 Terminei as 23:20
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> contas = new ArrayList<>(); // Lista para armazenar as contas criadas
        boolean contaEncontrada = false;

        boolean repeticao = true;

        while (repeticao) {

            System.out.println("\n=== Menu ===");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Realizar Deposito");
            System.out.println("3 - Consultar Saldo");
            System.out.println("4 - Realizar Saque");
            System.out.println("5 - Realizar Transferencia");
            System.out.println("6 - Lista Contas");
            System.out.println("7 - Sair");
            System.out.println("Digite uma Opcao: ");

            int operador = scanner.nextInt();
            scanner.nextLine();

            switch (operador) {
                case 1:
                    Cliente novaConta = new Cliente();

                    System.out.println("Opcao Selecionada: Criar Conta");
                    novaConta.criarConta(); // Chama o Metodo para Criar Conta
                    contas.add(novaConta);
                    break;

                case 2:
                    System.out.println("Opcao Selecionada: Realizar Deposito");
                    System.out.println("Informe o Numero da Conta");
                    int numeroConta = scanner.nextInt();
                    scanner.nextLine();

                    contaEncontrada = false;

                    for (Cliente clienteTemporario : contas) {
                        if (clienteTemporario.getNumConta() == numeroConta) {
                            clienteTemporario.realizarDeposito();
                            contaEncontrada = true;
                            break;
                        }
                    }

                    if (!contaEncontrada) {
                        System.out.println("Conta não encontrada.");
                    }
                    break;

                case 3:
                    System.out.println("Opcao Selecionada: Consultar Saldo");
                    int consultaSaldo = scanner.nextInt();
                    scanner.nextLine();
                    contaEncontrada = false;

                    for (Cliente clienteTemporario : contas) {
                        if (clienteTemporario.getNumConta() == consultaSaldo) {
                            clienteTemporario.consultarSaldo();
                            contaEncontrada = true;
                            break;
                        }
                    }
                    if (!contaEncontrada) {
                        System.out.println("Conta não Encontrada!");
                    }

                    break;
                case 4:
                    System.out.println("Opcao Selecionada: Realizar Saque");
                    System.out.println("Digite Numero da Conta: ");
                    int realizarSaque = scanner.nextInt();
                    contaEncontrada = false;

                    for (Cliente clienteTemporario : contas) {
                        if (clienteTemporario.getNumConta() == realizarSaque) {
                            clienteTemporario.realizarSaque();
                            contaEncontrada = true;
                        }
                    }
                    if (!contaEncontrada) {
                        System.out.println("Conta não Encontrada");
                    }

                    break;

                case 5:
                    System.out.println("Opcao Selecionada: Realizar Transferencia");
                    System.out.println("Digite Numero da Conta: ");
                    int realizarTransferencia = scanner.nextInt();

                    System.out.println("Digite o Numero da Conta para Transferencia: ");
                    int receberTransferencia = scanner.nextInt();

                    contaEncontrada = false;
                    Cliente contaOrigem = null;
                    Cliente contaDestino = null;

                    // Buscar Contas no Sistema
                    for (Cliente clienteTemporario : contas) {
                        if (clienteTemporario.getNumConta() == realizarTransferencia) {
                            contaOrigem = clienteTemporario;
                        } else if (clienteTemporario.getNumConta() == receberTransferencia) {
                            contaDestino = clienteTemporario;
                        }
                    }
                    if(contaOrigem == null) {
                        System.out.println("Conta Origem não Encontrada!");
                    } else if (contaDestino == null) {
                        System.out.println("Conta Destino não Encontrada!");
                    } else {
                        contaOrigem.realizarTransferencia(contaDestino);
                    }                
                    break;
                    
                case 6:
                    System.out.println("Opcao Selecionada: Exibir Contas");
                    if(contas.isEmpty()) {
                        System.out.println("Não existe Contas Cadastradas");
                    } else {
                        for (Cliente clienteTemporario : contas) {
                            clienteTemporario.visualizarContas();
                        }
                    }                  
                    break;

                case 7:
                    System.out.println("Opcao Selecionada: Sair");
                    System.out.println("Encerrando Sistema");
                    repeticao = false;
                    break;

            } // Fechamento do "Switch"

        } // Fechamento do "While"
    }

}
