package biblioteca.models;

import java.util.*;

public class Biblioteca {

    private String nome;
    private String cnpj;

    private List<ItemMultimidiaImpl> itens = new ArrayList<>();
    private int qtdMidias = 0;
    
    private MembroImpl[] membros = new MembroImpl[200000];
    private int qtdMembros = 0;

    private Emprestimo[] emprestimos = new Emprestimo[10000];

    public Biblioteca(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public String getNome() { return nome; }
    public String getCnpj() { return cnpj; }

    public List<ItemMultimidiaImpl> getItens(){ return itens; }

    public int getQtdMembros() { return qtdMembros; }
    public void setQtdMembros(int qtd){ this.qtdMembros = qtd; }

    public int getQtdMidias() { return qtdMidias; }
    public void setQtdMidias(int qtd) { this.qtdMidias = qtd; }
    
    // Outros Metodos
    public boolean verificaDisponibilidade(ItemMultimidiaImpl multimidia){ return true; }
    
    public boolean isMembro (MembroImpl p){
        for(int i = 0; i < getQtdMembros(); i++){
            if (membros[i].getRa() == p.getRa())
                return true;
        }
        return false;
    }

    public void adicionarMidia(ItemMultimidiaImpl midia){
        itens.add(midia);
    }

    public void removerMidia(ItemMultimidiaImpl midia){ 
        itens.remove(midia);
    }
    

    // Operacoes sobre os membros
    public void cadastrarMembro(MembroImpl pessoa){
        if (getQtdMembros() < 100000){
            membros[getQtdMembros()] = pessoa;
            setQtdMembros(qtdMembros+1);
        }else
            System.out.println("Quantidade maxima de usuarios lotada");
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
