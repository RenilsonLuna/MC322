package biblioteca.controllers;

import biblioteca.models.ItemMultimidia;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;
import biblioteca.models.QuantidadeMaximaException;

public interface EmprestimoController {
    void emprestar(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException;
    void devolver(ItemMultimidiaImpl item);
}
