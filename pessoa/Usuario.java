package pessoa;

import biblioteca.Livro;

public class Usuario {
    private String nome;
    private int documento;
    private boolean bloqueado = 0;
    private int nLivrosEmprestados = 0;
    private Livro livrosEmprestados[];

    public Usuario(String nome, String documento){
        this.nome = nome;
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public int getDocumento() {
        return documento;
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
