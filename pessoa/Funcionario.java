package pessoa;

import biblioteca.Livro;
import pessoa.Usuario;
import biblioteca.Biblioteca;
import java.util.Random;

public class Funcionario {
    private String nome;
    private String cargo;
    private int idFuncionario;

    public Funcionario(String nome, String cargo){
        this.nome = nome;
        this.cargo = cargo;
        
        Random rand = new Random();
        this.idFuncionario = rand.nextInt(10000);
    
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        if (usuario.getBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível realizar o empréstimo.");
            return;
        }

        if (!livro.getDisponivel()) {
            System.out.println("Livro já emprestado. Não é possível realizar o empréstimo.");
            return;
        }

        System.out.println("Livro emprestado com sucesso para " + usuario.getNome());
        livro.setDisponivel(false);
    }

    public void darBaixa(Livro livro, Usuario usuario){
        livro.setDisponivel(true);
        System.out.println("Livro devolvido com sucesso!\n --> Usuario ainda tem " + ( usuario.getNLivrosEmprestados() - 1) + " livro(s) emprestados");
    }

    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }


    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }   
}
