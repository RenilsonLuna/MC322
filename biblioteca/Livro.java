package biblioteca;

public class Livro {
    private String titulo;
    private String idLivro;
    private String[] autores;
    private String editora;
    private String edicao;
    private String genero;
    private String isbn;
    private int tombo;
    private boolean disponivel = true;

    public Livro(String titulo, String[] autores, String editora, String genero, int tombo){
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.genero = genero;
        this.tombo = tombo;
    }

    // Getters
    public String getTitulo() { return titulo; }

    public String[] getAutores() { return autores; }

    public String getEditora() { return editora; }

    public String getIdLivro() { return idLivro; }

    public String getGenero() { return genero; }

    public int getTombo() { return tombo; }

    public String getEdicao(){ return edicao; }
    
    public boolean getDisponivel() { return disponivel; }
    
    public String isbn() { return isbn; }


    // Setters
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }
    
}
