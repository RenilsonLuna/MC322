package biblioteca.controllers;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import biblioteca.models.*;


public class BibliotecaControllerImpl implements BibliotecaController {
    private Map<Integer, ItemMultimidiaImpl> itens;

    public BibliotecaControllerImpl(){
        this.itens = Biblioteca.getItens();
    }

    @Override
    public boolean adicionarItem(Scanner scanner){

        System.out.println("Tipo de multimidia: ");
        System.out.println("1. Livro Físico");
        System.out.println("2. Livro Digital");
        System.out.println("3. CD");
        System.out.println("4. DVD");

        System.out.println();
        System.out.print("Digite uma opção: ");

        int tipoMidia = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Titulo: ");
        String titulo = scanner.nextLine();
        
        System.out.print("Detalhes: ");
        String detalhes = scanner.nextLine();

        System.out.print("Autores: ");
        String autores = scanner.nextLine();

        System.out.print("Genero: ");
        String genero = scanner.nextLine();

        switch (tipoMidia) {
            case 1:
                System.out.print("Editora: ");
                String editora = scanner.nextLine();

                System.out.print("Edicao: ");
                int edicao = scanner.nextInt();
                scanner.nextLine();
                
                System.out.print("ISBN: ");
                String isbn = scanner.nextLine();

                System.out.print("Tombo: ");
                int tombo = scanner.nextInt();
                scanner.nextLine();


                LivroFisico l = new LivroFisico(id, titulo, detalhes, autores, genero, editora, edicao, isbn, tombo);
                Biblioteca.adicionarMidia(l);
                System.out.println("Livro Adicionado!");
                consultarItensDisponiveis();
                break;
            
            case 2: 
                // Livro digital
                break;
            case 3:
                System.out.print("Armazenamento: ");
                int armazenamento = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Distribuidora: ");
                String distribuidora = scanner.nextLine();

                System.out.print("Duração");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                
                Cd cd = new Cd(id, titulo, detalhes, autores, genero, armazenamento, distribuidora, duracao);
                Biblioteca.adicionarMidia(cd);
                System.out.print("CD adicionado!");
                break;
            case 4:
                
                System.out.print("Armazenamento: ");
                int armazenamento2 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Duracao: ");
                int duracao2 = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Distribuidora: ");
                String distribuidora2 = scanner.nextLine();

                boolean colorido = scanner.nextBoolean();

                Dvd dvd = new Dvd(id, titulo, detalhes, autores, genero, armazenamento2, distribuidora2, duracao2, colorido);

                Biblioteca.adicionarMidia(dvd);
                break;
            default:
                break;
        }
        return true;
    }

    @Override
    public boolean removerItem(Scanner scanner){
        try {
            System.out.print("Id do item: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            itens.remove(id);
            return true;
        } catch (Exception e) {
            return false;
        }
        
    }

    @Override
    public Map<Integer, ItemMultimidiaImpl> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(Membro membro, ItemMultimidiaImpl item) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverItem(Membro membro, ItemMultimidiaImpl item) {
        // Lógica de devolução
        return true;
    }
}