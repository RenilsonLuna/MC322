package biblioteca;
import biblioteca.multimidia.Multimidia;
import pessoa.Pessoa;

import java.time.LocalDate;



public class Emprestimo {

    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    protected Pessoa emprestante;
    private int codigoEmprestimo;
    protected Multimidia item;
    private static int qtdEmprestimos;

    public Emprestimo(LocalDate dataDevolucao, Pessoa emprestante, Multimidia item) {
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucao = dataDevolucao;
        this.item = item;
        this.emprestante = emprestante;
        this.codigoEmprestimo = qtdEmprestimos;
        qtdEmprestimos++;
    }

    // Getters e Setters
    public int getCodigoEmprestimo(){ return codigoEmprestimo; }
    public static void setQtdEmprestimos(int qtd) { qtdEmprestimos = qtd;}

    public LocalDate getDataEmprestimo() { return dataEmprestimo; }
    
    public Pessoa getEmprestante(){ return emprestante; }

    public LocalDate getDataDevolucao() { return dataDevolucao; }
    public void setDataDevolucao(LocalDate novaData){ this.dataDevolucao = novaData; }
    
    public Multimidia getItem() { return item; }

    public static int getQtdEmprestimos() { return qtdEmprestimos; }
}