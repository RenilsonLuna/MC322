package pessoa.funcionario;

import java.time.LocalDate;

import biblioteca.multimidia.*;
import pessoa.Pessoa;
import biblioteca.Emprestimo;
import biblioteca.Biblioteca;

public class Funcionario extends Pessoa{
    
    public Funcionario(String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);

        this.multimidiasEmprestadas = new Multimidia[4];
        this.prazoEmprestimo = 20;
        this.valorMulta = 0.75;
    }

    public void emprestar(Multimidia item, Pessoa usuario){
        if (item.getDisponivel()
            && usuario.getQtdMidiasEmprestadas() < usuario.getMultimidiasEmprestadas().length 
            && !usuario.getBloqueado()){

            LocalDate dataDevolucao = LocalDate.now().plusDays(usuario.getPrazoEmprestimo());
            Emprestimo emprestimo = new Emprestimo(dataDevolucao, usuario, item);
            lib.adicionarEmprestimo(emprestimo);
            usuario.addMultimidiaEmprestada(item);
            item.setDisponivel(false);

            System.out.println("------- Recibo de emprestimo -------- ");
            System.out.println("Codigo: " + emprestimo.getCodigoEmprestimo());
            System.out.println("Obra emprestada: " + emprestimo.getItem().getTitulo());
            System.out.println("Emprestante: " + emprestimo.getEmprestante().getNome() + " - " + emprestimo.getEmprestante().getRa());
            System.out.println("Data de emprestimo: " + emprestimo.getDataEmprestimo());
            System.out.println("Data de devolucao: " + emprestimo.getDataDevolucao());
            System.out.println("------- // -------- ");
        }else{
            System.out.println("Nao foi possivel realizar emprestimo.");
        }
    }
    
    public void devolucao(Multimidia item, Pessoa usuario){

        item.setDisponivel(true);
        LocalDate dataDeHoje = LocalDate.now();
        int qtdEmprestimos = Emprestimo.getQtdEmprestimos();
        Emprestimo[] emprestimos = lib.getEmprestimos();
        for(int i = 0; i < qtdEmprestimos; i++){
            if (emprestimos[i] != null && emprestimos[i].getItem().getIdMultimidia() == item.getIdMultimidia()){
                if (dataDeHoje.isBefore(emprestimos[i].getDataDevolucao())){
                    System.out.println("Emprestimo " + emprestimos[i].getCodigoEmprestimo() + " desfeito. Midia devolvida!");
                }else{
                    System.out.println("Usuario deve pagar multa de R$" + usuario.getValorMulta());                    
                }
                lib.removerEmprestimo(lib.getEmprestimos()[i]);
            }
        }

    }

    // protected void renovacao(Biblioteca lib, Multimidia)
}

