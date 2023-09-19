package biblioteca.views;

import java.util.List;

import biblioteca.controllers.MembroController;
import biblioteca.models.MembroImpl;

public class MembroViewImpl implements MembroView {
    private MembroController membroController;

    public MembroViewImpl(MembroController controller) {
        membroController = controller;
    }

    @Override
    public void mostrarListaMembros(List<MembroImpl> membros) {
        if(membros.isEmpty()){
            System.out.println("Não há membros na biblioteca");
        }
        else
            for (MembroImpl m : membros)
            System.out.println(m.getRa() + ": " + m.getNome());
    } 

    @Override
    public void mostrarDetalhesMembro(MembroImpl membro) {
        System.out.println("---- Dados do membro -------");
        System.out.println("Nome: " + membro.getNome());
        System.out.println("Documento: " + membro.getRa());
        System.out.println("Contato: " + membro.getContato());
        System.out.println("Endereco: " + membro.getEndereco());
    }
}