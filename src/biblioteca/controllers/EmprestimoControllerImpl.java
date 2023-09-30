package biblioteca.controllers;

import biblioteca.models.Biblioteca;
import biblioteca.models.Emprestimo;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;

// Exceptions
import biblioteca.models.QuantidadeMaximaException;
import biblioteca.models.ItemIndisponivelException;

public class EmprestimoControllerImpl implements EmprestimoController{

    @Override
    public void emprestar(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException, ItemIndisponivelException{
        if (membro.getQtdMidiasEmprestadas() >= membro.getLimiteEmprestimos()){
            throw new QuantidadeMaximaException("Quantidade máxima de livros excedida.");
        } if (!item.getDisponivel()){
            throw new ItemIndisponivelException("Item indisponível.");
        }
        Emprestimo emp = new Emprestimo(membro, item);
        Biblioteca.adicionarEmprestimo(emp);
    }

    @Override
    public void devolver(ItemMultimidiaImpl item) {
        Emprestimo[] emprestimos = Biblioteca.getEmprestimos();
        Emprestimo emp = null;
        for (Emprestimo m : emprestimos){
            if (m.getItem().getIdMultimidia() == item.getIdMultimidia())
                emp = m;
        }
        if (emp != null){
            Biblioteca.removerEmprestimo(emp);
        }
    }
}
