package biblioteca.controllers;

import java.util.Map;
import java.util.Scanner;

import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;
import biblioteca.models.QuantidadeMaximaException;

// import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    Map<Integer, ItemMultimidiaImpl> consultarItensDisponiveis();
    boolean adicionarItem(Scanner scanner);
    boolean removerItem(Scanner scanner);
    void emprestarItem(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException;
    boolean devolverItem(ItemMultimidiaImpl item);
    ItemMultimidiaImpl buscarItem(String titulo);
}