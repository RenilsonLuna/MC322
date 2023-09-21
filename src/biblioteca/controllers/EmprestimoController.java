package biblioteca.controllers;

import biblioteca.models.ItemMultimidia;
import biblioteca.models.Membro;

public interface EmprestimoController {
    void emprestar(ItemMultimidia item, Membro membro);
    void devolver(ItemMultimidia item);
}
