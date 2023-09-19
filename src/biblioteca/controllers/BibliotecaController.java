package biblioteca.controllers;

import java.util.Map;
import java.util.Scanner;

import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.Membro;

// import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    Map<Integer, ItemMultimidiaImpl> consultarItensDisponiveis();
    boolean adicionarItem(Scanner scanner);
    boolean removerItem(Scanner scanner);
    boolean emprestarItem(Membro membro, ItemMultimidiaImpl item);
    boolean devolverItem(Membro membro, ItemMultimidiaImpl item);
}