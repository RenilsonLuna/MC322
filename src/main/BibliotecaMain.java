package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import biblioteca.controllers.*;
import biblioteca.views.*;
import biblioteca.models.Biblioteca;
import biblioteca.models.Cd;
import biblioteca.models.Graduacao;
import biblioteca.models.HistoricoMultasException;
import biblioteca.models.ItemIndisponivelException;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.LivroFisico;
import biblioteca.models.MembroImpl;
import biblioteca.models.NaoEmprestadoException;
import biblioteca.models.QuantidadeMaximaException;


public class BibliotecaMain {
    private static BibliotecaController bibliotecaController;
    private static MembroController membroController;
    private static RelatorioController relatorioController;
    private static EmprestimoController emprestimoController;

    public static void main(String[] args) {

        LivroFisico l1 = new LivroFisico(0, "l1", "Livro de bolso", "Joao gomes, Carlos silva", "Comedia", "LPM", 0, "7kp21", 135523);
        LivroFisico l2 = new LivroFisico(1, "l2", "Livro de bolso", "Joao neto, Carlos mendes", "Comedia", "LPM", 0, "7kp21", 135553);
        Cd cd1 = new Cd(2, "cd1", "cd1", "Eu e tu", "Romance", 12, "pmm", 15);
        Cd cd2 = new Cd(3, "cd2", "cd2", "Eu e tu", "Romance", 12, "pmm", 15);
        Cd cd3 = new Cd(4, "cd3", "cd3", "Eu e tu", "Romance", 12, "pmm", 15);

        Biblioteca.adicionarMidia(l1);
        Biblioteca.adicionarMidia(l2);
        Biblioteca.adicionarMidia(cd1);
        Biblioteca.adicionarMidia(cd2);
        Biblioteca.adicionarMidia(cd3);

        Graduacao membro1 = new Graduacao("Renilson", "Rua luiz capucci", "9999999");
        Biblioteca.cadastrarMembro(membro1);
        
        bibliotecaController = new BibliotecaControllerImpl();
        membroController = new MembroControllerImpl();
        relatorioController = new RelatorioControllerImpl();
        emprestimoController = new EmprestimoControllerImpl();
        
        try{
            emprestimoController.emprestar(membro1, l1);
            emprestimoController.emprestar(membro1, l2);
            emprestimoController.emprestar(membro1, cd1);

            emprestimoController.devolver(membro1, cd1);
        }catch(QuantidadeMaximaException e){
            System.out.println(e.getMessage());
        } catch (ItemIndisponivelException e) {
            System.out.println(e.getMessage());
        }catch(HistoricoMultasException e){
            System.out.println(e.getMessage());
        }catch(NaoEmprestadoException e){
            System.out.println(e.getMessage());
        }

        BibliotecaView bibliotecaView = new BibliotecaViewImpl(bibliotecaController);
        MembroView membroView = new MembroViewImpl(membroController);
        // RelatorioView relatorioView = new RelatorioViewImpl(relatorioController);

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            
            System.out.println("---- Menu Biblioteca ----");
            System.out.println();
            System.out.println("1. Gerenciamento de Itens");
            System.out.println("2. Gerenciamento de Membros");
            System.out.println("3. Geração de Relatórios e Estatísticas");
            System.out.println("4. Administração de Funcionários");
            System.out.println("5. Sair");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    // Menu de Gerenciamento de Itens
                    menuGerenciamentoItens(scanner, bibliotecaView);
                    break;
                case 2:
                    // Menu de Gerenciamento de Membros
                    menuGerenciamentoMembros(scanner, membroView);
                    break;
                case 3:
                    // Menu de Geração de Relatórios e Estatísticas
                    // menuRelatoriosEstatisticas(scanner, relatorioView);
                    break;
                case 4:
                    // Menu de Administração de Funcionários
                    menuAdministracaoFuncionarios(scanner);
                    break;
                case 5:
                    System.out.println("Saindo do menu. Até logo!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuGerenciamentoItens(Scanner scanner, BibliotecaView bibliotecaView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Itens ----");
            System.out.println();
            System.out.println("1. Listar Itens Disponíveis");
            System.out.println("2. Adicionar Item");
            System.out.println("3. Editar Item");
            System.out.println("4. Remover Item");
            System.out.println("5. Empréstimo de Itens");
            System.out.println("6. Renovação de Empréstimos");
            System.out.println("7. Reservas de Itens");
            System.out.println("8. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");
            
            int opcaoItens = scanner.nextInt();
            scanner.nextLine();
            
            switch (opcaoItens) {
                case 1:
                    Map<Integer, ItemMultimidiaImpl> itens = bibliotecaController.consultarItensDisponiveis();
                    bibliotecaView.mostrarItensDisponiveis(itens);
                    break;
                case 2:
                    adicionarItem(scanner);
                    break;
                case 3:
                    editarItem(scanner);
                    break;
                case 4:
                    removerItem(scanner);
                    break;
                case 5:
                    realizarEmprestimo(scanner);
                    break;
                case 6:
                    realizarRenovacao(scanner);
                    break;
                case 7:
                    fazerReserva(scanner);
                    break;
                case 8:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
                }
            try {
                Thread.sleep(1000);
            } catch (Exception e) { }
        }
    }

    private static void menuGerenciamentoMembros(Scanner scanner, MembroView membroView) {
        while (true) {
            System.out.println("---- Menu Gerenciamento de Membros ----");
            System.out.println();
            System.out.println("1. Listar Membros");
            System.out.println("2. Adicionar Membro");
            System.out.println("3. Editar Membro");
            System.out.println("4. Remover Membro");
            System.out.println("5. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoMembros = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoMembros) {
                case 1:
                    List<MembroImpl> membros = membroController.listarMembros();
                    membroView.mostrarListaMembros(membros);
                    break;
                case 2:
                    adicionarMembro(scanner);
                    break;
                case 3:
                    editarMembro(scanner);
                    break;
                case 4:
                    removerMembro(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuRelatoriosEstatisticas(Scanner scanner, RelatorioView relatorioView) {
        while (true) {
            System.out.println("---- Menu Relatórios e Estatísticas ----");
            System.out.println();
            System.out.println("1. Gerar Relatório de Atividades de Membros");
            System.out.println("2. Gerar Relatório de Uso de Itens Multimídia");
            System.out.println("3. Gerar Relatório de Multas e Pagamentos");
            System.out.println("4. Gerar Relatório de Disponibilidade de Itens");
            System.out.println("5. Gerar Estatísticas de Uso por Perfil de Membro");
            System.out.println("6. Gerar Relatório de Itens Mais Populares");
            System.out.println("7. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoRelatorios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoRelatorios) {
                case 1:
                    gerarRelatorioAtividadesMembros();
                    break;
                case 2:
                    gerarRelatorioUsoItens();
                    break;
                case 3:
                    gerarRelatorioMultas();
                    break;
                case 4:
                    gerarRelatorioDisponibilidadeItens();
                    break;
                case 5:
                    gerarEstatisticasUsoPorPerfil();
                    break;
                case 6:
                    gerarRelatorioItensPopulares();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministracaoFuncionarios(Scanner scanner) {
        while (true) {
            System.out.println("---- Menu Administração de Funcionários ----");
            System.out.println();
            System.out.println("1. Administradores");
            System.out.println("2. Atendentes");
            System.out.println("3. Gerentes");
            System.out.println("4. Voltar");
            System.out.println();
            System.out.println();
            System.out.print("Escolha uma opção: ");

            int opcaoFuncionarios = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoFuncionarios) {
                case 1:
                    // Menu de Administração de Administradores
                    menuAdministradores(scanner);
                    break;
                case 2:
                    // Menu de Administração de Atendentes
                    menuAtendentes(scanner);
                    break;
                case 3:
                    // Menu de Administração de Gerentes
                    menuGerentes(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha novamente.");
            }
        }
    }

    private static void menuAdministradores(Scanner scanner) {
        // Lógica para administração de administradores
    }

    private static void menuAtendentes(Scanner scanner) {
        // Lógica para administração de atendentes
    }

    private static void menuGerentes(Scanner scanner) {
        // Lógica para administração de gerentes
    }

    // Métodos para realizar empréstimo, renovação e reserva
    private static void realizarEmprestimo(Scanner scanner) {

        System.out.print("Digite o titulo do item: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o RA do emprestante: ");
        int raMembro = scanner.nextInt();
        scanner.nextLine();

        MembroImpl membro = membroController.buscarMembroPorIdentificacao(raMembro);
        if (membro != null){
            System.out.println("Membro encontrado!");
        }else{
            System.out.println("Membro não encontrado...");
            return;
        }

        ItemMultimidiaImpl item = bibliotecaController.buscarItem(titulo);
        if (item != null){
            try{
                emprestimoController.emprestar(membro, item);
            }catch(QuantidadeMaximaException e){
                System.out.print("Erro no emprestimo: ");
                System.out.println(e.getMessage());
            }catch(ItemIndisponivelException e){
                System.out.print("Erro no emprestimo: ");
                System.out.println(e.getMessage());
            }catch(HistoricoMultasException e){
                System.out.print("Erro no emprestimo: ");
                System.out.println(e.getMessage());
            }
        }else{
            System.out.println("Item não encontrado");
        }
        


        System.out.println("Operação de Empréstimo de Itens");
    }

    private static void realizarRenovacao(Scanner scanner) {
        // Lógica para realizar uma renovação de empréstimo
        System.out.println("Operação de Renovação de Empréstimos");
    }

    private static void fazerReserva(Scanner scanner) {
        // Lógica para fazer uma reserva de item
        System.out.println("Operação de Reserva de Itens");
    }

    // Métodos para adicionar, editar e remover itens e membros
    private static void adicionarItem(Scanner scanner) {
        bibliotecaController.adicionarItem(scanner);
        System.out.println("Operação de Adição de Item");
    }

    private static void editarItem(Scanner scanner) {
        // Lógica para editar um item existente
        System.out.println("Operação de Edição de Item");
    }

    private static void removerItem(Scanner scanner) {
        bibliotecaController.removerItem(scanner);
        System.out.println("Operação de Remoção de Item");
    }

    private static void adicionarMembro(Scanner scanner) {
        
        membroController.adicionarMembro(scanner);
        System.out.println("Operação de Adição de Membro");
    }

    private static void editarMembro(Scanner scanner) {
        // Lógica para editar um membro existente
        System.out.println("Operação de Edição de Membro");
    }

    private static void removerMembro(Scanner scanner) {
        System.out.print("RA do membro: ");
        int ra = scanner.nextInt();
        scanner.nextLine();

        membroController.removerMembro(ra);
        System.out.println("Operação de Remoção de Membro");
    }

    // Métodos para gerar relatórios e estatísticas
    private static void gerarRelatorioAtividadesMembros() {
        // Lógica para gerar o Relatório de Atividades de Membros
        System.out.println("Gerando Relatório de Atividades de Membros");
    }

    private static void gerarRelatorioUsoItens() {
        // Lógica para gerar o Relatório de Uso de Itens Multimídia
        System.out.println("Gerando Relatório de Uso de Itens Multimídia");
    }

    private static void gerarRelatorioMultas() {
        // Lógica para gerar o Relatório de Multas e Pagamentos
        System.out.println("Gerando Relatório de Multas e Pagamentos");
    }

    private static void gerarRelatorioDisponibilidadeItens() {
        // Lógica para gerar o Relatório de Disponibilidade de Itens
        System.out.println("Gerando Relatório de Disponibilidade de Itens");
    }

    private static void gerarEstatisticasUsoPorPerfil() {
        // Lógica para gerar as Estatísticas de Uso por Perfil de Membro
        System.out.println("Gerando Estatísticas de Uso por Perfil de Membro");
    }

    private static void gerarRelatorioItensPopulares() {
        // Lógica para gerar o Relatório de Itens Mais Populares
        System.out.println("Gerando Relatório de Itens Mais Populares");
    }
}
