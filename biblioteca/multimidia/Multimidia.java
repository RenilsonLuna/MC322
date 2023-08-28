package biblioteca.multimidia;

public class Multimidia {
    private int idMultimidia;
    private String titulo;
    private String[] autores;
    private String genero;
    private String dataEntrada;

    
    public Multimidia(int idMultimidia, String titulo, String[] autores, String genero, String dataEntrada) {
        this.idMultimidia = idMultimidia;
        this.titulo = titulo;
        this.autores = autores;
        this.genero = genero;
        this.dataEntrada = dataEntrada;
    }

    public int getIdMultimidia() { return idMultimidia; }
    public void setIdMultimidia(int idMultimidia) { this.idMultimidia = idMultimidia; }
    
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    
    public String[] getAutores() { return autores; }
    public void setAutores(String[] autores) { this.autores = autores; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public String getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(String dataEntrada) { this.dataEntrada = dataEntrada; }

}
