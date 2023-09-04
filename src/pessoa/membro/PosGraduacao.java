package pessoa.membro;
import biblioteca.Biblioteca;
import biblioteca.multimidia.Multimidia;
import pessoa.Pessoa;

public class PosGraduacao extends Pessoa {
    private StrictoSensu nivel;// mestrado ou Doutorado
    private String insituto;

    public PosGraduacao(StrictoSensu nivel, String instituto, String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);
        this.nivel = nivel;
        this.insituto = instituto;

        this.multimidiasEmprestadas = new Multimidia[5];
        this.prazoEmprestimo = 20;
        this.valorMulta = 1;
    }

    public StrictoSensu getNivel() { return nivel; }
    public String getInsituto() { return insituto; }
}
