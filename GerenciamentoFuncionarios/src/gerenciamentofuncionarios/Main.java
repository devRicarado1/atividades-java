package gerenciamentofuncionarios;

// Atividade 5: Sistema de Gerenciamento de Funcionários (CRUD Completo com Cargo e Salário)
// Criar um sistema em Java que gerencie funcionários de uma empresa. Cada funcionário terá: Nome, CPF, Cargo, Salário
// Funcionalidades obrigatórias:  Cadastrar Funcionário, Listar Funcionários, Buscar Funcionário por CPF, Editar Funcionário Remover Funcionário
// Regras e Detalhes O CPF deve ser único. Os dados devem ser armazenados em um ArrayList. O menu será interativo com Scanner, 
// como nas atividades anteriores. Ao editar, permita alterar cargo e salário.
// Extras sugeridos (se quiser ir além): Validação básica do CPF (ex: 11 dígitos). Mostrar o salário formatado (ex: R$ 2.500,00).
// Calcular e mostrar a média salarial de todos os funcionários. Listar funcionários por cargo (ex: todos os "Analistas").
// Começei dia 13/05/2025 as 21:40

public class Main {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        
        funcionario.selecionaOpcoes(); // Chama Opcoes do Sistema
        
    }

}
