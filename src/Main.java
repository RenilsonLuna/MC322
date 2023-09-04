import java.time.LocalDate;

import biblioteca.*;
import biblioteca.multimidia.*;
import pessoa.*;
import pessoa.funcionario.*;
import pessoa.membro.*;

public class Main {

    public static void main(String[] args) {
    	Biblioteca lib = new Biblioteca("Cesar lattes", "116516516198");
        Funcionario funcionario1 = new Atendente("joao", "rua alzebio", "13 99699696", lib);
        Pessoa graduando = new Graduacao("carls", "Munici ramario", "13821981", lib);
        Pessoa posGraduando = new PosGraduacao(StrictoSensu.Mestrado, "IC", "Carlos", "Rua albino", "19 91994-9990", lib);

        String[] autores = {"Manuel"};
        Dispositivo[] disp = {Dispositivo.Celular, Dispositivo.Computador};

        Multimidia musica = new Cd(
            123, 
            "Cantigas", 
            autores, 
            "Romance", 
            15, 
            "Forrozera",
            10
        );
        
        Multimidia livro = new LivroDigital(
            262, 
            "A bela adormecida", 
            autores, 
            "Romance", 
            Formato.PDF, 
            2, 
            "https://www.sitedolivro.com", 
            disp, 
            LocalDate.now(), 
            3
        );

        graduando.solicitarEmprestimo(musica, funcionario1);
        System.out.println();
        posGraduando.solicitarEmprestimo(livro, funcionario1);
        System.out.println();

        graduando.realizarDevolucao(funcionario1, musica);
        System.out.println();
        posGraduando.realizarDevolucao(funcionario1, livro);
    }
}