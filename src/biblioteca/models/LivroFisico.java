package biblioteca.models;

public class LivroFisico extends ItemMultimidiaImpl{
    private String editora;
    private int edicao;
    private String isbn;
    private int tombo;
    private int qtdCopias;
    private static int qtdLivrosFisicos = 0;

    public LivroFisico(int idMultimidia, String titulo, String detalhes, String autores, String genero, String editora, int edicao,
            String isbn, int tombo, int qtdCopias) {
        super(idMultimidia, titulo, detalhes, autores, genero);
        this.editora = editora;
        this.edicao = edicao;
        this.isbn = isbn;
        this.tombo = tombo;
        this.qtdCopias = qtdCopias;
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
    public int getQtdCopias() { return qtdCopias; }
}
