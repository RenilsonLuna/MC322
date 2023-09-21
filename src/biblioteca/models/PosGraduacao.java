package biblioteca.models;

public class PosGraduacao extends MembroImpl {
    private StrictoSensu nivel;// mestrado ou Doutorado
    private String insituto;

    public PosGraduacao(StrictoSensu nivel, String instituto, String nome, String endereco, String contato){
        super(nome, endereco, contato);
        this.nivel = nivel;
        this.insituto = instituto;

        this.multimidiasEmprestadas = new ItemMultimidiaImpl[5];
        this.prazoEmprestimo = 20;
        this.valorMulta = 1;
    }

    public StrictoSensu getNivel() { return nivel; }
    public String getInsituto() { return insituto; }
}
