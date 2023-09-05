package biblioteca.multimidia;

public class Dvd extends Multimidia{
    // Padrao em megabytes
    private int armazenamento;
    private String distribuidora;
    private int duracao;
    private boolean colorido;
    private static int qtdDvd = 0;

    public Dvd(int idMultimidia, String titulo, String[] autores, String genero, int armazenamento,
            String distribuidora, int duracao, boolean colorido) {
        super(idMultimidia, titulo, autores, genero);
        this.armazenamento = armazenamento;
        this.distribuidora = distribuidora;
        this.duracao = duracao;
        this.colorido = colorido;

        qtdDvd++;
    }


    // Getters
    public int getArmazenamento() { return armazenamento; }
    public String getDistribuidora() { return distribuidora; }
    public int getDuracao() { return duracao; }
    public boolean getColorido() { return colorido; }
    public int getqtdDvd() { return qtdDvd; }

}