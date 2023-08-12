import pessoa.Usuario;
import pessoa.Funcionario;
import biblioteca.Livro;

public class Main {

    public static void main(String[] args) {
    	
        // Criando objetos de exemplo
        Usuario usuario1 = new Usuario("Carlos Alberto", "525153921");
        
        Livro livro1 = new Livro("Alem do bem e do mal", "Nietzsche", "L&PM", "Filosofia e etica", 121515);
        
        Funcionario funcionario = new Funcionario("Jose", "balconista");

        usuario1.solicitarEmprestimo(livro1, funcionario);
    }
}
