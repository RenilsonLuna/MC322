package biblioteca.models;
import java.time.LocalDate;


public abstract class ItemMultimidiaImpl implements ItemMultimidia{
    private int idMultimidia;
    private String titulo;
    private String detalhes;
    private String autores;
    private String genero;
    private LocalDate dataEntrada;
    private LocalDate dataEntrega;
    private boolean disponivel;
    private boolean conservado;
    private static int qtdMidias;
    protected MembroImpl reserva;
    private TipoMidia tipoMidia;
    
    public ItemMultimidiaImpl(int idMultimidia, TipoMidia tipoMidia, String titulo, String detalhes, String autores, String genero) {
        this.idMultimidia = idMultimidia;
        this.titulo = titulo;
        this.detalhes = detalhes;
        this.autores = autores;
        this.genero = genero;
        this.conservado = true;
        this.disponivel = true;
        qtdMidias++;
        this.tipoMidia = tipoMidia;
    }

    // Getters e setters
    public int getIdMultimidia() { return idMultimidia; }
    public void setIdMultimidia(int idMultimidia) { this.idMultimidia = idMultimidia; }
    
    public TipoMidia getTipoMidia() { return tipoMidia; }

    public LocalDate getDataEntrega(){ return dataEntrega;}

    public void setDataEntrega(ItemMultimidiaImpl item){ this.dataEntrega = item.dataEntrega; }

    public String getDetalhes(){ return detalhes; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutores() { return autores; }
    public void setAutores(String autores) { this.autores = autores; }
    
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    
    public LocalDate getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(LocalDate dataEntrada) { this.dataEntrada = dataEntrada; }

    public boolean getDisponivel() { return disponivel; }
    public void setDisponivel(boolean disponivel) { this.disponivel = disponivel; }

    public boolean getConservado() { return conservado; }
    public void setConservado(boolean conservacao) { this.conservado = conservacao; }

    public MembroImpl getReserva() { return reserva; }
    public void setReserva(MembroImpl reserva) { this.reserva = reserva; }

    public static int getQtdMidias(){ return qtdMidias; }
}
