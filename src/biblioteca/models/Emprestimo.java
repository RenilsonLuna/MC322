package biblioteca.models;
import java.time.LocalDate;



public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    protected MembroImpl emprestante;
    private int codigoEmprestimo;
    protected ItemMultimidiaImpl item;
    private static int qtdEmprestimos;

    public Emprestimo(MembroImpl emprestante, ItemMultimidiaImpl item) {
        this.dataEmprestimo = LocalDate.now();
        
        long prazo = emprestante.getPrazoEmprestimo();
        LocalDate dev = LocalDate.now().plusDays(prazo);
        this.dataDevolucao = dev;
        
        
        this.item = item;
        this.emprestante = emprestante;
        this.codigoEmprestimo = qtdEmprestimos;
        emprestante.addMultimidiaEmprestada(item);
        qtdEmprestimos++;
    }

    // Getters e Setters
    public int getCodigoEmprestimo(){ return codigoEmprestimo; }
    public static void setQtdEmprestimos(int qtd) { qtdEmprestimos = qtd;}

    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    
    public MembroImpl getEmprestante(){ return emprestante; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate novaData){ this.dataDevolucao = novaData; }
    
    public ItemMultimidiaImpl getItem() { return item; }

    public static int getQtdEmprestimos() { return qtdEmprestimos; }
}