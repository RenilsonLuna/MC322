package biblioteca.models;

import java.util.*;

public class Biblioteca {

    private String nome;
    private String cnpj;

    private Map<Integer, ItemMultimidiaImpl> itens = new HashMap<>();
    
    private List<MembroImpl> membros = new ArrayList<>();

    private Emprestimo[] emprestimos = new Emprestimo[10000];

    public Biblioteca(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }

    public Map<Integer, ItemMultimidiaImpl> getItens(){ return itens; }

    public List<MembroImpl> getMembros(){ return membros; }
    public int getQtdMembros() { return membros.size(); }

    public int getQtdMidias() { return itens.size(); }
    
    // Outros Metodos
    public boolean verificaDisponibilidade(ItemMultimidiaImpl multimidia){ return true; }
    
    public boolean isMembro (MembroImpl membro){
        for(MembroImpl m : membros)
            if (m.getRa() == membro.getRa())
                return true;
        return false;
    }

    // Operacoes sobre as midias
    public void adicionarMidia(ItemMultimidiaImpl midia){
        itens.put(midia.getIdMultimidia(), midia);
    }

    public void removerMidia(ItemMultimidiaImpl midia){ 
        itens.remove(midia.getIdMultimidia());
    }
    

    // Operacoes sobre os membros
    public void cadastrarMembro(MembroImpl membro){
        membros.add(membro);
    }

    public void removerMembro(MembroImpl membro){
        membros.remove(membro);
    }


    // Operacoes sobre os emprestimos
    public void adicionarEmprestimo(Emprestimo novoEmprestimo) {
        if (Emprestimo.getQtdEmprestimos() < emprestimos.length) 
            if (Emprestimo.getQtdEmprestimos() == 0)
                emprestimos[0] = novoEmprestimo; 
            else 
                emprestimos[Emprestimo.getQtdEmprestimos() - 1] = novoEmprestimo; 
    }   


    public void removerEmprestimo(Emprestimo emp){
        int qtdEmp = Emprestimo.getQtdEmprestimos();
        for(int i = 0; i < qtdEmp; i++){
            if (this.emprestimos[i] != null && emp.getCodigoEmprestimo() == this.emprestimos[i].getCodigoEmprestimo()){
                
                this.emprestimos[i] = this.emprestimos[qtdEmp - 1];
                this.emprestimos[qtdEmp - 1] = null;

                int nvQtd = Emprestimo.getQtdEmprestimos() - 1;
                Emprestimo.setQtdEmprestimos(nvQtd);
            }
        }
    }
    
    public Emprestimo[] getEmprestimos() { return emprestimos; }

    public void AdicionarReserva(MembroImpl usuario, ItemMultimidiaImpl midia){
        int i;
        for(i = 0; i< Emprestimo.getQtdEmprestimos(); i++){// Casas invalidas
            if(emprestimos[i].item == midia){// poderia colocar a edição tbm caso quisesse 
                emprestimos[i].item.setReserva(usuario);
            }
            
            System.out.println("O item:" + emprestimos[i].getItem().getTitulo() +" foi reservado para Sr(a)"+ usuario.getNome()+ "A previsão de entrega para " + emprestimos[i].getItem().getDataEntrega());

        }
    }
}
