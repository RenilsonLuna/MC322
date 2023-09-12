package biblioteca.controllers;

import biblioteca.views.RelatorioView;

public interface RelatorioController {
    public void gerarRelatorioAtividadesMembros(RelatorioView view);
    public void gerarRelatorioUsoItens(RelatorioView view);
    public void gerarRelatorioMultas(RelatorioView view);
    public void gerarRelatorioDisponibilidadeItens(RelatorioView view);
    public void gerarEstatisticasUsoPorPerfil(RelatorioView view);
    public void gerarRelatorioItensPopulares(RelatorioView view);
}