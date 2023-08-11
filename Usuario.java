import Livro;

public class Usuario {
    private String nome;
    private int ra;
    private boolean bloqueado;
    private int nLivrosEmprestados; // numero de livros emprestado
    private Livro livrosEmprestados[];

    public String getNome() {
        return nome;
    }

    public int getRA() {
        return RA;
    }


    public int getNLivrosEmprestados() {
        return nLivrosEmprestados;
    }

    public boolean isBloqueado() {
        return bloqueado;
    }

    public void solicitarEmprestimo() {
        if (isBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível solicitar empréstimo.");
            return;
        }

        if (nLivrosEmprestados >= 4) { 
            System.out.println("Limite de empréstimos excedido. Não é possível solicitar mais empréstimos.");
            return;
        }

        System.out.println("Livro emprestado com sucesso para " + getNome());
        nLivrosEmprestado++;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setBloqueado(boolean bloqueado) {
        this.bloqueado = bloqueado ? 1 : 0;
    }
    
    public void setNLemprestado(int NLemprestado) {
        this.nLemprestado = NLemprestado;
    }
}
