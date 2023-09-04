package biblioteca.multimidia;
import java.time.LocalDate;

public abstract class Multimidia {
    private int idMultimidia;
    private String titulo;
    private String[] autores;
    private String genero;
    private LocalDate dataEntrada;
    private LocalDate dataEntrega;
    private boolean disponivel;
    private String conservacao;
    private static int qtdMidias;
    
    public Multimidia(int idMultimidia, String titulo, String[] autores, String genero) {
        this.idMultimidia = idMultimidia;
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
        this.conservacao = "Novo";
        this.disponivel = true;
        qtdMidias++;
    }

    // Getters e setters
    public int getIdMultimidia() { return idMultimidia; }
    public void setIdMultimidia(int idMultimidia) { this.idMultimidia = idMultimidia; }
    
    public LocalDate getDataEntrega(){ return dataEntrega;}

    // ta certo ou coringuei?
    public void setDataEntrega(Multimidia item){
         this.dataEntrega=item.dataEntrega;
        }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String[] getAutores() { return autores; }
    public void setAutores(String[] autores) { this.autores = autores; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public boolean getDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public String getConservacao() { return conservacao; }
    public void setConservacao(String conservacao) { this.conservacao = conservacao; }


    public static int getQtdMidias(){ return qtdMidias; }

    // Outras funcoes
    protected int numCopiasDisponivel(Multimidia multiimdia, int edicao){
        return 0;
    }
    
}
