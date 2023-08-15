import pessoa.Usuario;
import pessoa.Funcionario;
import biblioteca.Biblioteca;
import biblioteca.Livro;

public class Main {

    public static void main(String[] args) {
    	
        // Criando objetos de exemplo
        Usuario usuario1 = new Usuario("Carlos Alberto", "525153921");
        
        Livro l1 = new Livro("Alem do bem e do mal", "Nietzsche", "L&PM", "Filosofia e etica", 000001);
        Livro l2 = new Livro("Bilhoes e Bilhoes", "Carl Segan", "L&PM", "Informativo", 000002);
        Livro l3 = new Livro("Cadeira", "bill", "oleira", "ironia", 000003);

        // Funcionario funcionario = new Funcionario("Jose", "balconista");

        Biblioteca lib = new Biblioteca("Biblioteca Central", "26656551/0255");
        lib.adicionarLivro(l1);
        lib.adicionarLivro(l2);
        lib.adicionarLivro(l3);

        lib.removerLivro(000002);

        // usuario1.solicitarEmprestimo(l1, funcionario);
        // usuario1.solicitarEmprestimo(livro2, funcionario);
        // usuario1.devolverLivro(livro1, funcionario);
    }
}
