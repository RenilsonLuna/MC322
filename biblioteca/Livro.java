package biblioteca;

public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String idLivro;
    private String genero;
    private int tombo;
    private boolean disponivel = 1; // Livro disponivel por padrao, assim que criado
    
    public Livro(String titulo, String autor, String editora, String genero, int tombo){
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.genero = genero;
        this.tombo = tombo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getEditora() {
        return editora;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public String getGenero() {
        return genero;
    }

    public int getTombo() {
        return tombo;
    }
    
    public boolean isEmprestado() {
        return disponivel;
    }

    public void setEmprestado(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
