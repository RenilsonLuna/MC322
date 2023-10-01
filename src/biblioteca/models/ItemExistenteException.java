package biblioteca.models;

public class ItemExistenteException extends Exception{
    public ItemExistenteException(String mensagem){
        super(mensagem);
    }
}