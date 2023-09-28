package biblioteca.controllers;

import java.util.Map;
import java.util.Scanner;

import biblioteca.models.ItemMultimidiaImpl;

// import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    Map<Integer, ItemMultimidiaImpl> consultarItensDisponiveis();
    boolean adicionarItem(Scanner scanner);
    boolean removerItem(Scanner scanner);
    ItemMultimidiaImpl buscarItem(String titulo);
}