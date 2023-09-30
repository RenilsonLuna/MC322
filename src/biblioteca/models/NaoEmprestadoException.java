package biblioteca.models;

public class NaoEmprestadoException extends Exception {
    public NaoEmprestadoException(String mensagem){
        super(mensagem);
    }
}