
public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String idLivro;
    private String genero;
    private int tombo;
    private boolean disponivel;


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
        return coordenada;
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
