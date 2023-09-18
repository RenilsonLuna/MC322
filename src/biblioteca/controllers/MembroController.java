package biblioteca.controllers;

import java.util.List;

import biblioteca.models.MembroImpl;

public interface MembroController {
    List<MembroImpl> listarMembros();
    MembroImpl buscarMembroPorIdentificacao(int identificacao);
    boolean adicionarMembro(MembroImpl membro);
    boolean removerMembro(int identificacao);
}