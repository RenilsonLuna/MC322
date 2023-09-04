package pessoa.membro;
import biblioteca.Biblioteca;
import biblioteca.multimidia.Multimidia;
import pessoa.Pessoa;

public class Graduacao extends Pessoa{
    
    public Graduacao(String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);
        this.valorMulta = 1;
        this.multimidiasEmprestadas = new Multimidia[3];
        this.prazoEmprestimo = 15;
    }
}