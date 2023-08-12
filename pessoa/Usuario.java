package pessoa;
import biblioteca.Livro;
import pessoa.Funcionario;

public class Usuario {
    private String nome;
    private String documento;
    private boolean bloqueado = false;
    private int nLivrosEmprestados = 0;
    private Livro[] livrosEmprestados = new Livro[4];

    	
    public Usuario(String nome, String documento){
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }


    public int getNLivrosEmprestados() {
        return nLivrosEmprestados;
    }

    public boolean getBloqueado() {
        return bloqueado;
    }

    public void solicitarEmprestimo(Livro livro, Funcionario funcionario) {
        if (getBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível solicitar empréstimo.");
            return;
        }

        if (nLivrosEmprestados >= 4) { 
            System.out.println("Limite de empréstimos excedido. Não é possível solicitar mais empréstimos.");
            return;
        }
        
        funcionario.realizarEmprestimo(this, livro);
        livrosEmprestados[nLivrosEmprestados] = livro;
        nLivrosEmprestados++;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
}
