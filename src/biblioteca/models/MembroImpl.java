package biblioteca.models;
// import biblioteca.Emprestimo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class MembroImpl implements Membro{
    
    protected String nome;
    protected int ra;
    protected static int contagemRa = 100000;
    protected String endereco;
    protected String contato;
    protected LocalDate dataRegistro;

    protected List<ItemMultimidiaImpl> multimidiasEmprestadas;
    private int qtdMidiasEmprestadas;
    protected int limiteEmprestimos;
    protected int prazoEmprestimo;

    protected double valorMulta;
    protected double totalMulta;
    
    protected boolean bloqueado = false;

    public MembroImpl(String nome, String endereco, String contato) {
        this.nome = nome;
        this.ra = contagemRa;
        this.endereco = endereco;
        this.contato = contato;
        this.dataRegistro = LocalDate.now();
        this.qtdMidiasEmprestadas = 0;
        this.multimidiasEmprestadas = new ArrayList<>();
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

    public int getLimiteEmprestimos() { return limiteEmprestimos; }
    
    public LocalDate getDataRegistro() { return dataRegistro; }
    
    public List<ItemMultimidiaImpl> getMultimidiasEmprestadas() { return multimidiasEmprestadas; }

    public int getPrazoEmprestimo() { return prazoEmprestimo; }

    public double getValorMulta() { return valorMulta; }

    public boolean getBloqueado() { return bloqueado; }

    
    // Other methods
    public void addMultimidiaEmprestada(ItemMultimidiaImpl item){
        multimidiasEmprestadas.add(item);
        int qtd = getQtdMidiasEmprestadas();
        this.setQtdMidiasEmprestadas(qtd + 1);
    }

    public void removerMultimidia(ItemMultimidiaImpl item){
        multimidiasEmprestadas.remove(item);
        int qtd = getQtdMidiasEmprestadas();
        setQtdMidiasEmprestadas(qtd - 1);
    }
    
    public void solicitarEmprestimo(ItemMultimidiaImpl item, Funcionario f){
        f.emprestar(item, this);
        addMultimidiaEmprestada(item);
    }

    public void realizarDevolucao(Funcionario f, ItemMultimidiaImpl m){
        f.devolucao(m, this);
        removerMultimidia(m);
    }
    
    public void solicitarRenovacao(ItemMultimidiaImpl item, Funcionario f){
        f.renovacao(item);
    }

    public void solicitarReserva(Administradores adm, ItemMultimidiaImpl item){
        adm.reservar(this, item);
    }
}    
