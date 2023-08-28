package biblioteca.multimidia;

public class Cd extends Multimidia{

    // armazenamento definido em megabytes
    private int armazenamento;
    private String distribuidora;
    private int duracao; // Padrao em minutos

    public Cd(int idMultimidia, String titulo, String[] autores, String genero, int quantidadeDisponivel,
            String dataEntrada, int armazenamento, String distribuidora, int duracao) {
        super(idMultimidia, titulo, autores, genero, dataEntrada);
        this.armazenamento = armazenamento;
        this.distribuidora = distribuidora;
        this.duracao = duracao;

        
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

    

    
}   
