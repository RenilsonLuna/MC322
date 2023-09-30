package biblioteca.controllers;

import biblioteca.models.ItemIndisponivelException;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;
import biblioteca.models.QuantidadeMaximaException;

public interface EmprestimoController {
    void emprestar(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException, ItemIndisponivelException;
    void devolver(ItemMultimidiaImpl item);
}
