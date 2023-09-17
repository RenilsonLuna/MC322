package biblioteca.controllers;

import java.util.List;

import biblioteca.models.*;

public class BibliotecaControllerImpl implements BibliotecaController {
    private List<ItemMultimidiaImpl> itens;

    public BibliotecaControllerImpl(Biblioteca lib){
        this.itens = lib.getItens();
    }

    @Override
    public List<ItemMultimidiaImpl> consultarItensDisponiveis() {
        return itens;
    }

    @Override
    public boolean emprestarItem(Membro membro, ItemMultimidiaImpl item) {
        // Lógica de empréstimo
        return true;
    }

    @Override
    public boolean devolverItem(Membro membro, ItemMultimidiaImpl item) {
        // Lógica de devolução
        return true;
    }
}