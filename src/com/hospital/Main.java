package com.hospital;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaPaciente repo = new ListaPaciente();

        while (true) {
            System.out.println("\nMENU:");
            System.out.println("1. Adicionar Paciente");
            System.out.println("2. Alterar Paciente");
            System.out.println("3. Excluir Paciente");
            System.out.println("4. Listar Pacientes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                   
                    System.out.print("Digite o ID do paciente: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome do paciente: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite o peso do paciente: ");
                    double peso = scanner.nextDouble();

                    System.out.print("Digite a altura do paciente: ");
                    double altura = scanner.nextDouble();

                    System.out.print("Digite o sexo do paciente (1 - Masculino, 2 - Feminino): ");
                    int sexo = scanner.nextInt();

                    Paciente paciente = new Paciente(id, nome, peso, altura, sexo);
                    repo.adicionarPaciente(paciente);
                    System.out.println("Paciente adicionado com sucesso!");
                    break;

                case 2:
                    
                    System.out.print("Digite o ID do paciente a ser alterado: ");
                    int idAlteracao = scanner.nextInt();
                    scanner.nextLine();

                    Paciente pacienteExistente = repo.buscarPacientePorId(idAlteracao);
                    if (pacienteExistente != null) {
                        System.out.print("Digite o novo nome do paciente: ");
                        String novoNome = scanner.nextLine();

                        System.out.print("Digite o novo peso do paciente: ");
                        double novoPeso = scanner.nextDouble();

                        System.out.print("Digite a nova altura do paciente: ");
                        double novaAltura = scanner.nextDouble();

                        System.out.print("Digite o novo sexo do paciente (1 - Masculino, 2 - Feminino): ");
                        int novoSexo = scanner.nextInt();

                        Paciente pacienteAlterado = new Paciente(idAlteracao, novoNome, novoPeso, novaAltura, novoSexo);
                        repo.alterarPaciente(idAlteracao, pacienteAlterado);
                        System.out.println("Paciente alterado com sucesso!");
                    } else {
                        System.out.println("Paciente não encontrado.");
                    }
                    break;

                case 3:
                   
                    System.out.print("Digite o ID do paciente a ser excluído: ");
                    int idExclusao = scanner.nextInt();
                    repo.excluirPaciente(idExclusao);
                    System.out.println("Paciente excluído com sucesso!");
                    break;

                case 4:
                    
                    repo.listarPacientes();
                    break;

                case 5:
                    
                    System.out.println("Saindo do programa...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
