package biblioteca.models;

public class Professor extends Pessoa {
    String disciplina;

    public Professor(String disciplina, String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);
        this.disciplina = disciplina;

        this.multimidiasEmprestadas = new ItemMultimidiaImpl[7];
        this.prazoEmprestimo = 30;
        this.valorMulta = 0.5;

    }

    public String getDisciplina() { return disciplina; }    
}
