package poogerenciacliente;

import java.util.Scanner;
        
public class Cliente {

    Scanner scanner = new Scanner(System.in);
    
    String nomeCliente;
    String emailCliente;
    String telefoneCliente;

    public Cliente(String nomeCliente, String emailCliente, String telefoneCliente) {
        this.nomeCliente = nomeCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
    }
    
    void cadastroCliente() {
        System.out.println("Digite o nome do cliente: ");
        nomeCliente = scanner.nextLine();
        System.out.println("Digite o E-mail do Cliente: ");
        emailCliente = scanner.nextLine();
        System.out.println("Digite o telefone do Cliente: ");
        telefoneCliente = scanner.nextLine();
    }
    
    void clientesCadastrados(int contador) {
        System.out.println("[" + contador +"] Nome " + nomeCliente + " Email: " + emailCliente + " Telefone: " + telefoneCliente);       
    }
    
    void editarCliente() {
        System.out.println("Informe as informacoes do cliente que deseja editar: ");
        System.out.println("Digite o Nome do Cliente: ");
        nomeCliente = scanner.nextLine();
        System.out.println("Digite o E-mail do Cliente: ");
        emailCliente = scanner.nextLine();
        System.out.println("Digite o telefone do Cliente: ");
        telefoneCliente = scanner.nextLine();
    }
    
    void removeCliente() {
        System.out.println("Cliente Removido");
        System.out.println(" Nome " + nomeCliente + " Email: " + emailCliente + " Telefone: " + telefoneCliente);  
    }
}
