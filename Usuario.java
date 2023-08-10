
public class Usuario {
    private String nome;
    private int RA;
    private int bloqueado;
    private int nLemprestado; // numero de livros emprestado

    public String getNome() {
        return nome;
    }

    public int getRA() {
        return RA;
    }


    public int getNLemprestadoemprestado() {
        return nLemprestado;
    }

    public boolean isBloqueado() {
        return bloqueado == 1; // Retorna true se bloqueado for igual a 1, caso contrário, retorna false.
    }

    public void solicitarEmprestimo() {
        if (isBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível solicitar empréstimo.");
            return;
        }

        if (nLemprestado >= 4) { 
            System.out.println("Limite de empréstimos excedido. Não é possível solicitar mais empréstimos.");
            return;
        }

        System.out.println("Livro emprestado com sucesso para " + getNome());
        nLemprestado++;
    }

}
