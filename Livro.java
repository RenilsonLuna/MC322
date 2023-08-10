
public class Livro {
    private String titulo;
    private String autor;
    private String editora;
    private String id;
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

    public String getId() {
        return id;
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

    public void setEmprestado(boolean emprestado) {
        this.disponivel = disponivel;
    }

}
