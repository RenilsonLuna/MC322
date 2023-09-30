package biblioteca.models;

import java.util.*;

public class Biblioteca {

    private static Map<Integer, ItemMultimidiaImpl> itens = new HashMap<>();
    
    private static List<MembroImpl> membros = new ArrayList<>();

    private static Emprestimo[] emprestimos = new Emprestimo[10000];

    public static Map<Integer, ItemMultimidiaImpl> getItens(){ return itens; }

    public static List<MembroImpl> getMembros(){ return membros; }
    public static int getQtdMembros() { return membros.size(); }

    public static int getQtdMidias() { return itens.size(); }
    
    // Outros Metodos
    public static ItemMultimidiaImpl buscar(String titulo){
        for (ItemMultimidiaImpl item : Biblioteca.getItens().values()){
            if (item.getTitulo().equals(titulo)){
                return item;
            }
        }
        return null;
    }
    
    public static boolean isMembro (MembroImpl membro){
        for(MembroImpl m : membros)
            if (m.getRa() == membro.getRa())
                return true;
        return false;
    }

    // Operacoes sobre as midias
    public static void adicionarMidia(ItemMultimidiaImpl midia){
        itens.put(midia.getIdMultimidia(), midia);
    }

    public static void removerMidia(ItemMultimidiaImpl midia){ 
        itens.remove(midia.getIdMultimidia());
    }
    

    // Operacoes sobre os membros
    public static void cadastrarMembro(MembroImpl membro){
        membros.add(membro);
    }

    public static void removerMembro(MembroImpl membro){
        membros.remove(membro);
    }


    // Operacoes sobre os emprestimos
    public static void adicionarEmprestimo(Emprestimo novoEmprestimo) {
        if (Emprestimo.getQtdEmprestimos() < emprestimos.length) 
            if (Emprestimo.getQtdEmprestimos() == 0)
                emprestimos[0] = novoEmprestimo; 
            else 
                emprestimos[Emprestimo.getQtdEmprestimos() - 1] = novoEmprestimo; 
    }   

    public static void removerEmprestimo(Emprestimo emp){
        int qtdEmp = Emprestimo.getQtdEmprestimos();
        for(int i = 0; i < qtdEmp; i++){
            if (emprestimos[i] != null && emp.getCodigoEmprestimo() == emprestimos[i].getCodigoEmprestimo()){
                
                emprestimos[i] = emprestimos[qtdEmp - 1];
                emprestimos[qtdEmp - 1] = null;

                int nvQtd = Emprestimo.getQtdEmprestimos() - 1;
                Emprestimo.setQtdEmprestimos(nvQtd);
            }
        }
    }
    
    public static Emprestimo[] getEmprestimos() { return emprestimos; }

    public static void AdicionarReserva(MembroImpl usuario, ItemMultimidiaImpl midia){
    }
}