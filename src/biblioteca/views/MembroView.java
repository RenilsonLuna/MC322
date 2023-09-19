package biblioteca.views;

import java.util.List;

import biblioteca.models.MembroImpl;

public interface MembroView {
    void mostrarListaMembros(List<MembroImpl> membros);
    void mostrarDetalhesMembro(MembroImpl membro);
}