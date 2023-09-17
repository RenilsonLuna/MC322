package biblioteca.views;

import java.util.List;

import biblioteca.models.ItemMultimidiaImpl;

public interface BibliotecaView {
    void mostrarItensDisponiveis(List<ItemMultimidiaImpl> itens);
    void mostrarEmprestimoStatus(boolean sucesso);
    void mostrarDevolucaoStatus(boolean sucesso);
}