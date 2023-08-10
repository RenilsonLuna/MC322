
public class biblioteca {
    private String nomeBiblioteca;
    private int nTotalLivro;
    private int nEmprestLivro;

    /* 
    será que realmente é necessário esse método? Visto que funcionario que chama pra emprestar o livro
    public void emprestarLivro(Usuario usuario, Livro livro) {
        // Lógica para empréstimo do livro
        // Exemplo: atualizar status do livro, registrar o empréstimo para o usuário, etc.
    }
    

    public void devolverLivro(Usuario usuario, Livro livro) {
        // Lógica para devolução do livro
        // Exemplo: atualizar status do livro, registrar a devolução, etc.
    }

    */

    public void setNEmprestLivro(int nEmprestLivro) {
        this.nEmprestLivro = nEmprestLivro+1;
    }

}
