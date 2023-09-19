package biblioteca.views;

import java.util.Map;

import biblioteca.controllers.BibliotecaController;
import biblioteca.models.ItemMultimidiaImpl;

public class BibliotecaViewImpl implements BibliotecaView {
    private BibliotecaController bibliotecaController;

    public BibliotecaViewImpl(BibliotecaController controller) {
        bibliotecaController = controller;
    }

    @Override
    public void mostrarItensDisponiveis(Map<Integer, ItemMultimidiaImpl> itens) {

        if (itens.isEmpty()){
            System.out.println("Lista de Itens vazia.");
        }else{
            System.out.println("------ Itens disponíveis ------");

            for(ItemMultimidiaImpl item : itens.values()){
                System.out.println(item.getIdMultimidia() + ". " + item.getTitulo() + " - " + item.getAutores());
            }
        }
    }

    @Override
    public void mostrarEmprestimoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Empréstimo realizado com sucesso.");
        } else {
            System.out.println("Falha ao realizar o empréstimo.");
        }
    }

    @Override
    public void mostrarDevolucaoStatus(boolean sucesso) {
        if (sucesso) {
            System.out.println("Devolução realizada com sucesso.");
        } else {
            System.out.println("Falha ao realizar a devolução.");
        }
    }
}