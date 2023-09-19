package biblioteca.views;

import java.util.Map;

import biblioteca.models.ItemMultimidiaImpl;

public interface BibliotecaView {
    void mostrarItensDisponiveis(Map<Integer, ItemMultimidiaImpl> itens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}