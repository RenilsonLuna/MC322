package pessoa.membro;
import biblioteca.Biblioteca;

public class Graduacao extends PessoaGenerico{
    String Curso;

    //Reutilizandoo construtor da superClasse
    public Graduacao(String nome, String Documento, String TipoDocumento, int tempo, int QuantLivros, String Curso, Biblioteca lib){
        super(nome, Documento,TipoDocumento,tempo, QuantLivros, lib);
        this.Curso=Curso;
        lib.cadastrarMembro(Documento);
    }
}
    



