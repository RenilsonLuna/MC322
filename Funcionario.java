
public class Funcionario {
    private String nome;
    private String cargo;
    private String idFuncionario;

    public Funcionario(String nome, String cargo){
        this.nome = nome;
        this.cargo = cargo;
        // Gerar codigo aleatorio para id
        // ...
    
    }

    public void realizarEmprestimo(Usuario usuario, Livro livro) {
        if (usuario.isBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível realizar o empréstimo.");
            return;
        }

        if (livro.isEmprestado()) {
            System.out.println("Livro já emprestado. Não é possível realizar o empréstimo.");
            return;
        }

        // Realizar a logica de emprestimo:
        // - Atualizar o status do livro (emprestado)
        // - Registrar o empréstimo para o usuário
        System.out.println("Livro emprestado com sucesso para " + usuario.getNome());
        livro.setEmprestado(false); // o livro deixa de estar disponivel

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
