package biblioteca.models;

public class Cd extends ItemMultimidiaImpl{

    // armazenamento definido em megabytes
    private int armazenamento;
    private String distribuidora;
    private int duracao; // Padrao em minutos
    private static int qtdCds = 0;


    public Cd(int idMultimidia, String titulo, String detalhes, String[] autores, String genero, int armazenamento, String distribuidora,
            int duracao) {
        super(idMultimidia, titulo, detalhes, autores, genero);
        this.armazenamento = armazenamento;
        this.distribuidora = distribuidora;
        this.duracao = duracao;

        qtdCds++;
    }

    // Getters
    public int getArmazenamento() { return armazenamento; }
    public int getDuracao() { return duracao; }
    public int getQtdCd(){ return qtdCds; }
    public String getDistribuidora() { return distribuidora; }
}   
