package biblioteca.controllers;

import biblioteca.models.Biblioteca;
import biblioteca.models.Emprestimo;
import biblioteca.models.HistoricoMultasException;
import biblioteca.models.ItemMultimidiaImpl;
import biblioteca.models.MembroImpl;

// Exceptions
import biblioteca.models.QuantidadeMaximaException;
import biblioteca.models.NaoEmprestadoException;
import biblioteca.models.ItemIndisponivelException;

public class EmprestimoControllerImpl implements EmprestimoController{

    @Override
    public void emprestar(MembroImpl membro, ItemMultimidiaImpl item) throws QuantidadeMaximaException, ItemIndisponivelException, HistoricoMultasException{
        if (membro.getQtdMidiasEmprestadas() >= membro.getLimiteEmprestimos()){
            throw new QuantidadeMaximaException("Quantidade máxima de livros excedida.");
        } if (!item.getDisponivel()){
            throw new ItemIndisponivelException("Item indisponível.");
        }if (membro.getTotalMulta() > 0){
            throw new HistoricoMultasException("Multas a serem pagas.");
        }
        Emprestimo emp = new Emprestimo(membro, item);
        Biblioteca.adicionarEmprestimo(emp);
    }

    @Override
    public void devolver(MembroImpl membro, ItemMultimidiaImpl item) throws NaoEmprestadoException {

        // Tratando exception
        boolean itemEmprestado = false;
        for (ItemMultimidiaImpl em : membro.getMultimidiasEmprestadas()){
            if (item.getIdMultimidia() == em.getIdMultimidia()){
                itemEmprestado = true;
            }
        }

        if (itemEmprestado == false){
            throw new NaoEmprestadoException("Item Nao emprestado.");
        }

        Emprestimo[] emprestimos = Biblioteca.getEmprestimos();
        Emprestimo emp = null;
        for (Emprestimo m : emprestimos){
            if (m != null && m.getItem().getIdMultimidia() == item.getIdMultimidia())
                emp = m;
        }
        if (emp != null){
            Biblioteca.removerEmprestimo(emp);
        }
    }
}
