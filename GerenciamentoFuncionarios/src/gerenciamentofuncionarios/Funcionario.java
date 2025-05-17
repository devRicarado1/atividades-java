package gerenciamentofuncionarios;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Funcionario {

    Scanner scanner = new Scanner(System.in);
    List<Funcionario> colaboradores = new ArrayList<>(); //Lista para Armazena os Colaboradores

    String nome;
    String cpf;
    String cargo;
    double salario;

    public Funcionario() {
        this.salario = 0.0;
    }

    public String formataCPF(String cpf) {
        if (cpf != null && cpf.length() == 11) {
            return cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
        } else {
            System.out.println("CPF INVALIDO");
            return null;
        }
    }

    void cadastraFuncionario() { // Fazer Validação Caso CPF já tenha um cadastrado Igual.
        System.out.println("CADASTRO DE FUNCIONARIO\n");
        System.out.println("Digite o nome Funcionario: ");
        nome = scanner.nextLine();
        System.out.println("Digite seu CPF: ");
        cpf = scanner.nextLine();
        if (cpf != null && cpf.length() == 11) {
            // Verifica se o CPF e Valido, sendo Continuar o Cadastro
        } else {
            System.out.println("CPF INVALIDO");
            return;
        }
        System.out.println("Digite o Cargo do Funcionario: ");
        cargo = scanner.nextLine();
        System.out.println("Digite o Salario do Funcionario: ");
        salario = scanner.nextDouble();
        if (salario <= 0) {
            System.out.println("SALÁRIO INVÁLIDO! O salário deve ser maior que zero.");
        }

        // Criando um Objeto Para Funcionario para adiciona no ArrayList
        Funcionario novoFuncionario = new Funcionario();
        novoFuncionario.nome = nome;
        novoFuncionario.cpf = cpf;
        novoFuncionario.cargo = cargo;
        novoFuncionario.salario = salario;
        colaboradores.add(novoFuncionario);
        System.out.println("FUNCIONÁRIO CADASTRADO COM SUCESSO!");
    }

    void listarFuncionarios() {
        if (colaboradores.isEmpty()) {
            System.out.println("NENHUM FUNCIONARIO CADASTRADO");
            return;
        }

        System.out.println("\n==================== DADOS DO FUNCIONÁRIO ====================");
        System.out.printf("%-20s: %s\n", "Nome", nome);
        System.out.printf("%-20s: %s\n", "CPF", formataCPF(cpf));
        System.out.printf("%-20s: %s\n", "Cargo", cargo);
        System.out.printf("%-20s: R$ %.2f\n", "Salário", salario);
        System.out.println("=============================================================");

    }

    void buscarFuncionario() { // FAZER BUSCAR POR CPF

        if (colaboradores.isEmpty()) { //Verifica se Possuir Algum Funcionario Cadastro dentro do ArrayList
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("Digite o CPF do Funcionario para Buscar: ");
        String localizarFuncionario = scanner.nextLine();
        scanner.nextLine();

        localizarFuncionario = localizarFuncionario.replaceAll("[^0-9]", ""); // Remove todos os caracteres não numéricos

        if (localizarFuncionario.length() == 11) {
            if (localizarFuncionario.equals(cpf)) {
                System.out.println("Funcionario Localizado");
                listarFuncionarios();
            } else {
                System.out.println("FUNCIONARIO NÃO LOCALIZADO");
            }
        } else {
            System.out.println("CPF INVÁLIDO! O CPF deve conter 11 dígitos numéricos.");
        }
    }

    void editarFuncionario() { // Fazer a Função para Editar Funcionario.
        System.out.println("Digite o CPF do Funcionario que Deseja Editar: ");
        String editarFuncionario = scanner.nextLine();
        scanner.nextLine();

        editarFuncionario = editarFuncionario.replaceAll("^[0-9]", ""); // Remove todos os caracteres não numéricos

        if (colaboradores.isEmpty()) { //Verifica se Possuir Algum Funcionario Cadastro dentro do ArrayList
            System.out.println("NENHUM FUNCIONARIO CADASTRADO");
            return;
        }
        if (editarFuncionario.length() == 11) {
            
            if (editarFuncionario.equals(cpf)) {
                //Quando o Funcionario For Localizado.

            } else {
                System.out.println("FUNCIONARIO NÃO LOCALIZADO");
            }
        } else {
            System.out.println("CPF INVÁLIDO! O CPF deve conter 11 dígitos numéricos.");
        }

    }

    void removeFuncionario() {

    }

    void selecionaOpcoes() {
        boolean repeticao = true; //Boolean para o Switch fica infito até seleciona a Opção de Sair

        while (repeticao) {

            System.out.println("\n====================================");
            System.out.println("   GESTÃO DE FUNCIONÁRIOS");
            System.out.println("====================================");
            System.out.println("1. Cadastrar Funcionário");
            System.out.println("2. Listar Funcionários");
            System.out.println("3. Buscar Funcionário");
            System.out.println("4. Editar Funcionário");
            System.out.println("5. Remover Funcionário");
            System.out.println("6. Sair");
            System.out.println("====================================");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    cadastraFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    buscarFuncionario();
                    break;
                case 4:
                    editarFuncionario();
                    break;
                case 5:
                    removeFuncionario();
                    break;
                case 6:
                    repeticao = false;
                    System.out.println("Encerrando...");
                    break;
                default:
                    System.out.println("OPCAO INCORRETA");
            }
        }
    }

}

// Remover qualquer caractere não numérico do CPF informado
// A expressão regular "[^0-9]" encontra todos os caracteres que não são números (0-9).
// O método replaceAll substitui esses caracteres não numéricos por uma string vazia (""),
// ou seja, remove os pontos, traços e outros símbolos do CPF digitado pelo usuário.
// localizarFuncionario = localizarFuncionario.replaceAll("[^0-9]", "");
