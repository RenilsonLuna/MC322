package biblioteca.models;

public class Professor extends MembroImpl {
    String disciplina;

    public Professor(String disciplina, String nome, String endereco, String contato){
        super(nome, endereco, contato);
        this.disciplina = disciplina;

        this.multimidiasEmprestadas = new ItemMultimidiaImpl[7];
        this.prazoEmprestimo = 30;
        this.valorMulta = 0.5;

    }

    public String getDisciplina() { return disciplina; }    
}
