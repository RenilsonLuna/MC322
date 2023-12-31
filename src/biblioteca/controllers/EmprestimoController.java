package biblioteca.controllers;

import biblioteca.models.HistoricoMultasException;
import biblioteca.models.ItemIndisponivelException;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;
import biblioteca.models.NaoEmprestadoException;
import biblioteca.models.QuantidadeMaximaException;

public interface EmprestimoController {
    void emprestar(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException, ItemIndisponivelException, HistoricoMultasException;
    void devolver(MembroImpl membro, ItemMultimidiaImpl item) throws NaoEmprestadoException;
}
