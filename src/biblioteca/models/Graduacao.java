package biblioteca.models;

public class Graduacao extends MembroImpl{
    
    public Graduacao(String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);
        this.valorMulta = 1;
        this.multimidiasEmprestadas = new ItemMultimidiaImpl[3];
        this.prazoEmprestimo = 15;
    }
}