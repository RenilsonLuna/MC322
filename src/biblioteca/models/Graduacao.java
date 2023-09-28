package biblioteca.models;

public class Graduacao extends MembroImpl{
    
    public Graduacao(String nome, String endereco, String contato){
        super(nome, endereco, contato);
        this.valorMulta = 1;
        this.limiteEmprestimos = 3;
        this.prazoEmprestimo = 15;
    }
}