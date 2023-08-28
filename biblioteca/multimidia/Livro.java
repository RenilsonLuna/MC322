package biblioteca.multimidia;

public class Livro extends Multimidia{
    private String editora;
    private String edicao;
    private String isbn;
    private int tombo;

    public Livro(int idMultimidia, String titulo, String[] autores, String genero, String dataEntrada, String editora, String edicao, String isbn, int tombo) {
        super(idMultimidia, titulo, autores, genero, dataEntrada);
        
        this.editora = editora;
        this.edicao = edicao;
        this.isbn = isbn;
        this.tombo = tombo;
    }
    
    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public String getEdicao() { return edicao; }
    public void setEdicao(String edicao) { this.edicao = edicao; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public int getTombo() { return tombo; }
    public void setTombo(int tombo) { this.tombo = tombo; }

}
