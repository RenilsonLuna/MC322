package pessoa.membro;
import biblioteca.Biblioteca;

public class Professor extends PessoaGenerico {
    String disciplina;

    public Professor(String nome, String Documento, String TipoDocumento, int tempo, String disciplina, int QuantLivros, Biblioteca lib){
        super(nome, Documento,TipoDocumento,tempo, QuantLivros, lib);
        this.disciplina=disciplina;   
    }
}
