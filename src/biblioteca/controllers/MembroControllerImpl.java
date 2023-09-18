package biblioteca.controllers;

import java.util.List;

import biblioteca.models.Biblioteca;
import biblioteca.models.MembroImpl;

public class MembroControllerImpl implements MembroController {
    private Biblioteca lib;

    public MembroControllerImpl(Biblioteca lib) {
        this.lib = lib;
    }

    @Override
    public List<MembroImpl> listarMembros() {
        return lib.getMembros();
    }

    @Override
    public MembroImpl buscarMembroPorIdentificacao(int identificacao) {
        for (MembroImpl m : lib.getMembros())
            if (m.getRa() == identificacao)
                return m;
        return null;
    }

    public boolean adicionarMembro(MembroImpl membro){
        try {
            lib.cadastrarMembro(membro);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean removerMembro(int identificacao){
        for (MembroImpl m : lib.getMembros()){
            if (m.getRa() == identificacao){
                lib.removerMembro(m);
                return true;
            }
        }
        return false;
    }
}