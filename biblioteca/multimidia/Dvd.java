package biblioteca.multimidia;

public class Dvd extends Multimidia{
    // Padrao em megabytes
    private int armazenamento;
    private String distribuidora;
    private int duracao;
    private boolean colorido;

    
    public Dvd(int idMultimidia, String titulo, String[] autores, String genero, int quantidadeDisponivel,
            String dataEntrada, int armazenamento, String distribuidora, int duracao, boolean colorido) {
        super(idMultimidia, titulo, autores, genero, dataEntrada);
        this.armazenamento = armazenamento;
        this.distribuidora = distribuidora;
        this.duracao = duracao;
        this.colorido = colorido;
    }

    // Getters e setters
    public int getArmazenamento() {
        return armazenamento;
    }
 

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }


    public String getDistribuidora() {
        return distribuidora;
    }


    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }


    public int getDuracao() {
        return duracao;
    }


    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }


    public boolean getColorido() {
        return colorido;
    }


    public void setColorido(boolean colorido) {
        this.colorido = colorido;
    }

    


}
