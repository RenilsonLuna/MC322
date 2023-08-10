
public class Funcionario {
    private String nome;
    private String cargo;
    private int RA;

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public int getRA() {
        return RA;
    }

    public void emprestarLivro(Usuario usuario, Livro livro) {
        if (usuario.isBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível realizar o empréstimo.");
            return;
        }

        if (livro.isEmprestado()) {
            System.out.println("Livro já emprestado. Não é possível realizar o empréstimo.");
            return;
        }

        // Realizar a lógica de empréstimo:
        // - Atualizar o status do livro (emprestado)
        // - Registrar o empréstimo para o usuário
        System.out.println("Livro emprestado com sucesso para " + usuario.getNome());
    }
}
