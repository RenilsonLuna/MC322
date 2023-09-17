package biblioteca.controllers;

import java.util.List;

import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.Membro;
// import biblioteca.views.BibliotecaView;

public interface BibliotecaController {
    List<ItemMultimidiaImpl> consultarItensDisponiveis();
    boolean emprestarItem(Membro membro, ItemMultimidiaImpl item);
    boolean devolverItem(Membro membro, ItemMultimidiaImpl item);
}