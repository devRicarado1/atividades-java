package atividadebancariafacil;

import java.util.Scanner;

public class Cliente {

    Scanner scanner = new Scanner(System.in);

    private String nomeTitular;
    private int numConta;
    private double saldoConta;
    private static int geradorNumeroContas = 0; // Gerador Começa em 1

    public Cliente() {
        this.numConta = ++geradorNumeroContas; // Gera um novo Numero para a Conta
        this.saldoConta = 0.0; // Saldo Incial da Conta
    }

    void criarConta() {
        System.out.println("Digite o Nome Titular da Conta: ");
        nomeTitular = scanner.nextLine();
        System.out.println("Numero da Conta: " + numConta);
        System.out.println("Conta Criada Com Sucesso!");
    }

    void consultarSaldo() {
        System.out.println("Para Consulta o Saldo Informe o Numero da Conta");
        System.out.println("Numero da Conta: ");
        int verificarNumConta = scanner.nextInt();
        scanner.nextLine();

        if (verificarNumConta != numConta) {
            System.out.println("Dados da Conta Incorreto!");
        } else {
            System.out.println("Nome do Titular: " + nomeTitular);
            System.out.println(" Numero da Conta ( " + numConta + " )");
            System.out.println("Saldo em Conta ( " + saldoConta + " )");
        }
    }

    void realizarDeposito() {
        System.out.println("Para Realizar o Deposito Informe o Valor do Deposito");
        System.out.println("Saldo Atual da sua Conta R$: " + saldoConta);

        double deposito = scanner.nextDouble();
        scanner.nextLine();

        if (deposito <= 0) {
            System.out.println("Valor Invalido Para Deposito");
        } else {
            saldoConta += deposito;
            System.out.println("Depósito de R$ " + deposito + " realizado com sucesso!");
            System.out.println("Novo saldo: R$ " + saldoConta);
        }

    }
    
    void realizarSaque() {
        System.out.println("Para Realiar o Saque Informe o Valor do Deposito");
        System.out.println("Saldo Atual da sua Conta R$: " + saldoConta);
        
        System.out.println("Digite o Valor que Deseja Sacar: ");
        double saque = scanner.nextDouble();
        
        if (saque > saldoConta) {
            System.out.println("Saldo Insuficiente, Saldo Atual e: " + saldoConta);
        } else if (saque <= 0) {
            System.out.println("Digite um Valor Valido para Realizar o Saque");
        } else {
            saldoConta -= saque;
            System.out.println("Saque de R$: " + saque + " Realizado com Sucesso!");
        }
        
    }
    
    void realizarTransferencia(Cliente contaDestino) {
        System.out.println("Para Realizar a Transferencia Informe o Valor para Transferencia");
        System.out.println("Saldo Atual da sua Conta R$" + saldoConta);
        
        System.out.println("Digite o Valor que Deseja Transferir: ");
        double transferencia = scanner.nextDouble();
        
        if (transferencia > saldoConta) {
            System.out.println("Saldo Insuficiente, Saldo Atual e:" + saldoConta);
        } else if (transferencia <= 0) {
            System.out.println("Digite um Valor Valido para Realizar a Transferencia");
        } else {
            saldoConta -= transferencia;
            contaDestino.saldoConta += transferencia; 
            System.out.println("Transferencia de R$: " + transferencia + "Realizado com Sucesso!");
        }
    }
    
    void visualizarContas() {
        System.out.println("\nNome Titular: " + nomeTitular + " Numero da Conta " + numConta + " Saldo Atal R$ : " + saldoConta + "\n");
    }
    

    public int getNumConta() {
        return numConta;
    }

    public double getsaldoConta() {
        return saldoConta;
    }

    public void setsaldoConta(double saldoConta) {
        this.saldoConta = saldoConta;
    }

} // Fechamento da Public Class cliente
