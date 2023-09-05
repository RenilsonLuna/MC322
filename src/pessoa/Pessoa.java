package pessoa;
// import biblioteca.Emprestimo;
import java.time.LocalDate;

import biblioteca.Biblioteca;
//import biblioteca.multimidia.Livro;
import biblioteca.multimidia.Multimidia;
import pessoa.funcionario.Administradores;
import pessoa.funcionario.Funcionario;

public abstract class Pessoa {
    
    protected String nome;
    protected int ra;
    protected static int contagemRa = 100000;
    protected String endereco;
    protected String contato;
    protected LocalDate dataRegistro;

    protected Multimidia[] multimidiasEmprestadas;
    private int qtdMidiasEmprestadas = 0;

    protected int prazoEmprestimo;
    protected double valorMulta;
    protected double totalMulta;
    
    protected boolean bloqueado = false;
    protected Biblioteca lib;

    public Pessoa(String nome, String endereco, String contato, Biblioteca lib) {
        this.nome = nome;
        this.ra = contagemRa;
        this.endereco = endereco;
        this.contato = contato;
        this.lib = lib;
        this.dataRegistro = LocalDate.now();

        contagemRa++;
    }
    
    // Getters e Setters
    public int getQtdMidiasEmprestadas(){ return qtdMidiasEmprestadas; }
    private void setQtdMidiasEmprestadas(int qtd){ this.qtdMidiasEmprestadas = qtd; }

    public String getNome() { return nome; }
    public int getRa() { return ra; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getContato() { return contato; }
    public void setContato(String contato) { this.contato = contato; }

    public double getTotalMulta() { return totalMulta; }
    public void setTotalMulta(double totalMulta) { this.totalMulta = totalMulta; }

    
    public LocalDate getDataRegistro() { return dataRegistro; }
    
    public Multimidia[] getMultimidiasEmprestadas() { return multimidiasEmprestadas; }
    
    public Biblioteca getLib() { return lib; }

    public int getPrazoEmprestimo() { return prazoEmprestimo; }

    public double getValorMulta() { return valorMulta; }

    public boolean getBloqueado() { return bloqueado; }


    public void addMultimidiaEmprestada(Multimidia item){
        int qtd = getQtdMidiasEmprestadas();
        multimidiasEmprestadas[qtd] = item;
        setQtdMidiasEmprestadas(qtd + 1);
    }

    // Other methods
    public void removerMultimidia(Multimidia item){
        int qtd = getQtdMidiasEmprestadas();
        for(int i = 0; i < qtd; i++){
            if (multimidiasEmprestadas[i] != null){
                int id = multimidiasEmprestadas[i].getIdMultimidia();
                if (item.getIdMultimidia() == id){;
                    multimidiasEmprestadas[qtd - 1] = multimidiasEmprestadas[i];
                    multimidiasEmprestadas[qtd - 1] = null;
                }
            }
        }
        setQtdMidiasEmprestadas(getQtdMidiasEmprestadas() - 1);
    }
    
    public void solicitarEmprestimo(Multimidia item, Funcionario f){
        f.emprestar(item, this);
        addMultimidiaEmprestada(item);
    }

    public void realizarDevolucao(Funcionario f, Multimidia m){
        f.devolucao(m, this);
        removerMultimidia(m);
    }
    
    public void solicitarRenovacao(Multimidia item, Funcionario f){
        f.renovacao(item);
    }

    public void solicitarReserva(Administradores adm, Multimidia item){
        adm.reservar(this, item);
    }
}    
