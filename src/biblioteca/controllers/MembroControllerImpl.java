package biblioteca.controllers;

import java.util.List;
import java.util.Scanner;

import biblioteca.models.*;

public class MembroControllerImpl implements MembroController {

    public MembroControllerImpl() { }

    @Override
    public List<MembroImpl> listarMembros() {
        return Biblioteca.getMembros();
    }

    @Override
    public MembroImpl buscarMembroPorIdentificacao(int identificacao) {
        for (MembroImpl m : Biblioteca.getMembros())
            if (m.getRa() == identificacao)
                return m;
        return null;
    }

    public boolean adicionarMembro(Scanner scanner){

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Endereco: ");
        String endereco = scanner.nextLine();

        System.out.print("Contato: ");
        String contato = scanner.nextLine();
        
        System.out.println("1. Atendente");
        System.out.println("2. Gerente");
        System.out.println("3. Administrador");
        System.out.println("4. Graduacao");
        System.out.println("5. Pos-Graduacao");
        System.out.println("6. Professor");
        
        System.out.println();
        System.out.print("Selecione o tipo de membro: ");
        int tipoMembro = scanner.nextInt();
        scanner.nextLine();

        switch (tipoMembro) {
            case 1:
                Atendente a = new Atendente(nome, endereco, contato);
                Biblioteca.cadastrarMembro(a);
                break;
            case 2:
                Gerente g = new Gerente(nome, tipoMembro, endereco, contato);
                Biblioteca.cadastrarMembro(g);
                break;
            case 3:
                Administradores adm = new Administradores(nome, endereco, contato);
                Biblioteca.cadastrarMembro(adm);
                break;
            case 4:
                Graduacao grad = new Graduacao(nome, endereco, contato);
                Biblioteca.cadastrarMembro(grad);
                break;

            case 5:
                System.out.print("1. Doutorado\n2. Mestrado\n\nSelecione o grau: ");
                int grau = scanner.nextInt();
                scanner.nextLine();
                StrictoSensu s;

                if (grau == 1)
                    s = StrictoSensu.Doutorado;
                else    
                    s = StrictoSensu.Mestrado;
                
                PosGraduacao pos = new PosGraduacao(s, contato, nome, endereco, contato);
                Biblioteca.cadastrarMembro(pos);


            default:
                break;
        }

        return true;
    }

    public boolean removerMembro(int identificacao){
        for (MembroImpl m : Biblioteca.getMembros()){
            if (m.getRa() == identificacao){
                Biblioteca.removerMembro(m);
                return true;
            }
        }
        return false;
    }
}