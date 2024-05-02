import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Tarefa> tarefas = new ArrayList<>();

            while (true) {
                System.out.println("\nMENU:");
                System.out.println("1 - Incluir Tarefa");
                System.out.println("2 - Pesquisar Tarefa");
                System.out.println("3 - Remover Tarefa");
                System.out.println("4 - Sair");
                System.out.print("Escolha uma opção: ");

                int escolha;
                try {
                    escolha = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após a leitura do número
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.nextLine(); // Limpar entrada inválida
                    continue;
                }

                switch (escolha) {
                    case 1:
                        System.out.print("Descrição da Tarefa: ");
                        String descricao = scanner.nextLine();
                        System.out.print("Tempo Estimado (horas): ");
                        int tempoEstimado;
                        try {
                            tempoEstimado = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número.");
                            scanner.nextLine(); // Limpar entrada inválida
                            continue;
                        }
                        System.out.print("Nome do Técnico: ");
                        String nomeTecnico = scanner.nextLine();
                        Tecnico responsavel = new Tecnico(nomeTecnico);

                        System.out.println("Tipo de Tarefa:");
                        System.out.println("1 - Suporte");
                        System.out.println("2 - Desenvolvimento");
                        System.out.print("Escolha uma opção: ");
                        int tipoTarefa;
                        try {
                            tipoTarefa = scanner.nextInt();
                            scanner.nextLine(); // Consumir a quebra de linha
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("Entrada inválida. Por favor, insira um número.");
                            scanner.nextLine(); // Limpar entrada inválida
                            continue;
                        }

                        if (tipoTarefa == 1) {
                            System.out.print("Tempo Máximo (dias): ");
                            int tempoMax;
                            try {
                                tempoMax = scanner.nextInt();
                                scanner.nextLine(); // Consumir a quebra de linha
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("Entrada inválida. Por favor, insira um número.");
                                scanner.nextLine(); // Limpar entrada inválida
                                continue;
                            }
                            System.out.print("Urgente (S ou N): ");
                            char urgente = scanner.next().charAt(0);
                            scanner.nextLine(); // Consumir a quebra de linha
                            TarefaSuporte tarefaSuporte = new TarefaSuporte(descricao, tempoEstimado, responsavel, tempoMax, urgente);
                            tarefas.add(tarefaSuporte);
                        } else if (tipoTarefa == 2) {
                            System.out.print("Linguagem de Programação: ");
                            String linguagem = scanner.nextLine();
                            System.out.print("Tipo (N para Nova Funcionalidade, C para Correção): ");
                            char tipo = scanner.next().charAt(0);
                            scanner.nextLine(); // Consumir a quebra de linha
                            TarefaDev tarefaDev = new TarefaDev(descricao, tempoEstimado, responsavel, linguagem, tipo);
                            tarefas.add(tarefaDev);
                        } else {
                            System.out.println("Opção inválida.");
                        }
                        break;

                    case 2:
                        System.out.print("Digite a descrição da tarefa que deseja pesquisar: ");
                        String descricaoPesquisa = scanner.nextLine();
                        for (Tarefa tarefa : tarefas) {
                            if (tarefa.getDescricao().equalsIgnoreCase(descricaoPesquisa)) {
                                System.out.println("Tarefa: " + tarefa.getDescricao());
                                System.out.println("Tempo Estimado: " + tarefa.getTempoEstimado() + " horas");
                                System.out.println("Responsável: " + tarefa.getResponsavel().getNome());
                                if (tarefa instanceof TarefaSuporte) {
                                    TarefaSuporte tarefaSuporte = (TarefaSuporte) tarefa;
                                    System.out.println("Tipo: Suporte");
                                    System.out.println("Tempo Máximo: " + tarefaSuporte.getTempoMax() + " dias");
                                    System.out.println("Urgente: " + tarefaSuporte.getUrgente());
                                } else if (tarefa instanceof TarefaDev) {
                                    TarefaDev tarefaDev = (TarefaDev) tarefa;
                                    System.out.println("Tipo: Desenvolvimento");
                                    System.out.println("Linguagem: " + tarefaDev.getLinguagem());
                                    System.out.println("Tipo: " + tarefaDev.getTipo());
                                }
                                break;
                            }
                        }
                        break;

                    case 3:
                        System.out.print("Digite a descrição da tarefa que deseja remover: ");
                        String descricaoRemover = scanner.nextLine();
                        Tarefa tarefaRemover = null;
                        for (Tarefa tarefa : tarefas) {
                            if (tarefa.getDescricao().equalsIgnoreCase(descricaoRemover)) {
                                tarefaRemover = tarefa;
                                break;
                            }
                        }
                        if (tarefaRemover != null) {
                            tarefas.remove(tarefaRemover);
                            System.out.println("Tarefa removida com sucesso.");
                        } else {
                            System.out.println("Tarefa não encontrada.");
                        }
                        break;

                    case 4:
                        System.out.println("Total de Tarefas: " + tarefas.size());
                        System.out.println("Encerrando o programa.");
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }
        }
    }
}
