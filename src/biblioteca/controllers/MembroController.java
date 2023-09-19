package biblioteca.controllers;

import java.util.List;
import java.util.Scanner;

import biblioteca.models.MembroImpl;

public interface MembroController {
    List<MembroImpl> listarMembros();
    MembroImpl buscarMembroPorIdentificacao(int identificacao);
    boolean adicionarMembro(Scanner scanner);
    boolean removerMembro(int identificacao);
}