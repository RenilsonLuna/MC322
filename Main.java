import pessoa.membro.Funcionario;
import pessoa.membro.Graduacao;
import pessoa.membro.PosGraduacao;
import pessoa.membro.Professor;
import biblioteca.Biblioteca;
import biblioteca.multimidia.Multimidia;
import biblioteca.multimidia.Livro;

public class Main {

    public static void main(String[] args) {
    	
        // String documento = "247035";
        // int tamanho = documento.length();
        // char firstCharacter = documento.charAt(0);

        // if( documento.length()==6){ // ver se o documento é RA(ou seja está vinculado com a unicamp)
            
        //     if(firstCharacter=='2'){ // se começa com o num 2 entao é graduação
                 
        //     }

        //     if(firstCharacter=='3'){
        //         Professor usuario2 = new Professor("Falcao", "379965", "RA", 28, "Estrutura De Dados",10);  
        //     }

        //     if(firstCharacter=='4'){
        //         PosGraduacao usuario3 = new PosGraduacao("Renilson", "236645","RA", 7, "Mestrado", "IC",10); 
        //     }

        // }

        Biblioteca lib = new Biblioteca("Cesar Lattes", "123161915216");
        Funcionario funcionario = new Funcionario("Silvia", "Diretora", lib); 
        Graduacao usuario = new Graduacao("Damner", "247035","RA", 7,10, "Computação", lib);

        String[] autores = {"Sun tzu"};
        Livro l1 = new Livro(123456, "A arte da Guerra", autores, "Estrategia", "27/08/2023", "Hunter Books", "1st", "123a4", 15263);
        lib.adicionarLivro(l1);
        usuario.solicitarEmprestimo(l1, funcionario);
        usuario.devolverLivro(l1.getIdMultimidia());

        // Livro l2 = new Livro("Bilhoes e Bilhoes", "Carl Segan", "L&PM", "Informativo", 000002);
        // Livro l3 = new Livro("Cadeira", "bill", "oleira", "ironia", 000003);

        // Funcionario funcionario = new Funcionario("Jose", "balconista");

        // Biblioteca lib = new Biblioteca("Biblioteca Central", "26656551/0255");
        // lib.adicionarLivro(l1);
        // lib.adicionarLivro(l2);
        // lib.adicionarLivro(l3);

        // lib.removerLivro(000002);

        // usuario1.solicitarEmprestimo(l1, funcionario);
        // usuario1.solicitarEmprestimo(livro2, funcionario);
        // usuario1.devolverLivro(livro1, funcionario);
    }

}


