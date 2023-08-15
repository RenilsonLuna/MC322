package pessoa;
import biblioteca.Livro;
import pessoa.Funcionario;

public class Usuario {
    private String nome;
    private String ra;
    private boolean bloqueado = false;
    private Livro[] livrosEmprestados = new Livro[4];
    private int nLivrosEmprestados = 0;

    	
    public Usuario(String nome, String ra){
        this.nome = nome;
        this.ra = ra;
    }

    
    public void solicitarEmprestimo(Livro livro, Funcionario funcionario) {
        if (getBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível solicitar empréstimo.");
            return;
        }
        
        if (getNLivrosEmprestados() >= 4) { 
            System.out.println("Limite de empréstimos excedido. Não é possível solicitar mais empréstimos.");
            return;
        }
        
        funcionario.realizarEmprestimo(this, livro);
        livrosEmprestados[getNLivrosEmprestados()] = livro;
        nLivrosEmprestados++;
    }
    
    public void devolverLivro(Livro livro, Funcionario func){
        func.darBaixa(livro, this);
        livrosEmprestados[nLivrosEmprestados - 1] = null;
        nLivrosEmprestados--;
    }

    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getDocumento() {
        return ra;
    }
    
    
    public int getNLivrosEmprestados() {
        return nLivrosEmprestados;
    }
    
    public boolean getBloqueado() {
        return bloqueado;
    }
    

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setBloquado(boolean valor){
        this.bloqueado = valor;
    }
}
