package biblioteca.models;

import java.time.LocalDate;

public class LivroDigital extends ItemMultimidiaImpl {
    private Formato formato;
    private int numLicencas = 0;
    private String url;
    private Dispositivo[] compatibilidade;
    private LocalDate dataDisponibilidade;
    private int totalLicencas;
    private static int qtdLivrosDigitais = 0;

    public LivroDigital(int idMultimidia, String titulo, String detalhes, String autores, String genero, Formato formato,
            int numLicencas, String url, Dispositivo[] compatibilidade, LocalDate dataDisponibilidade,
            int totalLicencas) {

        super(idMultimidia, titulo, detalhes, autores, genero);
        this.formato = formato;
        this.numLicencas = numLicencas;
        this.url = url;
        this.compatibilidade = compatibilidade;
        this.dataDisponibilidade = dataDisponibilidade;
        this.totalLicencas = totalLicencas;

        qtdLivrosDigitais++;
    }

    public Formato getFormato() { return formato; }
    public void setFormato(Formato formato) { this.formato = formato; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Dispositivo[] getCompatibilidade() { return compatibilidade; }
    public void setCompatibilidade(Dispositivo[] compatibilidade) { this.compatibilidade = compatibilidade; }

    public LocalDate getDataDisponibilidade() { return dataDisponibilidade; }
    public void setDataDisponibilidade(LocalDate dataDisponibilidade) { this.dataDisponibilidade = dataDisponibilidade; }

    public int getTotalLicencas() { return totalLicencas; }
    public void setTotalLicencas(int totalLicencas) { this.totalLicencas = totalLicencas; }

    public static int getQtdLivrosDigitais() { return qtdLivrosDigitais; }
    public int getNumLicencas() { return numLicencas; }
}
