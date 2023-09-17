package biblioteca.models;

import java.time.LocalDate;

public interface ItemMultimidia {
    String getTitulo();
    String getDetalhes();

    // Getters e setters
    public int getIdMultimidia();
    public void setIdMultimidia(int idMultimidia);    
    public LocalDate getDataEntrega();

    public void setTitulo(String titulo);

    public String getAutores();
    public void setAutores(String autores);
    
    public String getGenero();
    public void setGenero(String genero);
    
    public LocalDate getDataEntrada();
    public void setDataEntrada(LocalDate dataEntrada);

    public boolean getDisponivel();
    public void setDisponivel(boolean disponivel);

    public String getConservacao();
    public void setConservacao(String conservacao);

    public Pessoa getReserva();
    public void setReserva(Pessoa reserva);
}