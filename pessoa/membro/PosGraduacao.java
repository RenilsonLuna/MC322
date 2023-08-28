package pessoa.membro;
import biblioteca.Biblioteca;

public class PosGraduacao extends PessoaGenerico {
    String nivel;// mestrado ou Doutorado
    String insituto;

    public PosGraduacao(String nome, String Documento, String TipoDocumento, int tempo, String nivel, String instituto, int QuantLivros, Biblioteca lib){
        super(nome, Documento,TipoDocumento,tempo, QuantLivros, lib);
        this.insituto=instituto;
        this.nivel=nivel;
    }
}
