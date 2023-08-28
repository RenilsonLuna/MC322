package pessoa.membro;
import biblioteca.multimidia.Livro;
import biblioteca.multimidia.Multimidia;
import biblioteca.Biblioteca;

abstract class PessoaGenerico {
    protected String nome;
    protected String Documento;  // a pessoa pode entrar na biblioteca nao só com o RA
    protected String TipoDocumento; // informa que tipo de documento ela usou
    protected boolean bloqueado = false;
    protected Livro[] livrosEmprestados = new Livro[4]; // mudar de 4 pra um numero flexivel, tem que ser aq?
    protected int nLivrosEmprestados = 0;
    protected int tempo;
    private Biblioteca lib;


    public PessoaGenerico(String nome, String Documento, String TipoDocumento, int tempo, int QuantLivros, Biblioteca lib){
        this.nome=nome;
        this.Documento=Documento;
        this.TipoDocumento= TipoDocumento;
        this.tempo=tempo; // o tempo que pode ficar com livro emprestado
        this.lib = lib;

    }

    public String getNome() {
        return nome;
    }
    
    public String getDocumento() {
        return Documento;
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

    public void solicitarEmprestimo(Livro livro, Funcionario funcionario) {
        if (getBloqueado()) {
            System.out.println("Usuário bloqueado. Não é possível solicitar empréstimo.");
            return;
        }
        
        if (getNLivrosEmprestados() >= 4) { 
            System.out.println("Limite de empréstimos excedido. Não é possível solicitar mais empréstimos.");
            return;
        }
        
        funcionario.realizarEmprestimo(this.getDocumento(), (Multimidia)livro);
        livrosEmprestados[getNLivrosEmprestados()] = livro;
        nLivrosEmprestados += 1;
    }
    
    public void devolverLivro(int idMultimidia){
        this.lib.removerReserva(idMultimidia);
        nLivrosEmprestados--;
    }
}


    

