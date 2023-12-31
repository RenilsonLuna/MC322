package biblioteca.models;

public class LivroFisico extends ItemMultimidiaImpl{
    private String editora;
    private int edicao;
    private String isbn;
    private int tombo;
    private static int qtdLivrosFisicos = 0;

    public LivroFisico(int idMultimidia, TipoMidia tipoMidia, String titulo, String detalhes, String autores, String genero, String editora, int edicao,
            String isbn, int tombo) {
        super(idMultimidia, tipoMidia, titulo, detalhes, autores, genero);
        this.editora = editora;
        this.edicao = edicao;
        this.isbn = isbn;
        this.tombo = tombo;
        qtdLivrosFisicos++;
    }
    
    public String getEditora() { return editora; }
    public void setEditora(String editora) { this.editora = editora; }

    public int getEdicao() { return edicao; }
    public void setEdicao(int edicao) { this.edicao = edicao; }

    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    
    public int getTombo() { return tombo; }
    public void setTombo(int tombo) { this.tombo = tombo; }

    public static int getQtdLivrosFisicos() { return qtdLivrosFisicos; }
}
