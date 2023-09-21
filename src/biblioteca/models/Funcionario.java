package biblioteca.models;

import java.time.LocalDate;

public class Funcionario extends MembroImpl{
    
    public Funcionario(String nome, String endereco, String contato){
        super(nome, endereco, contato);

        this.multimidiasEmprestadas = new ItemMultimidiaImpl[4];
        this.prazoEmprestimo = 20;
        this.valorMulta = 0.75;
    }

    public void emprestar(ItemMultimidiaImpl item, MembroImpl usuario){
        if (item.getDisponivel()
            && usuario.getQtdMidiasEmprestadas() < usuario.getMultimidiasEmprestadas().length 
            && !usuario.getBloqueado()){

            Emprestimo emprestimo = new Emprestimo(usuario, item);
            Biblioteca.adicionarEmprestimo(emprestimo);
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
    
    public void devolucao(ItemMultimidiaImpl item, MembroImpl usuario){
        item.setDisponivel(true);
        LocalDate dataDeHoje = LocalDate.now();
        int qtdEmprestimos = Emprestimo.getQtdEmprestimos();
        Emprestimo[] emprestimos = Biblioteca.getEmprestimos();
        for(int i = 0; i < qtdEmprestimos; i++){
            if (emprestimos[i] != null && emprestimos[i].getItem() == item){
                if (dataDeHoje.isBefore(emprestimos[i].getDataDevolucao())){
                    System.out.println("Emprestimo " + emprestimos[i].getCodigoEmprestimo() + " desfeito. Midia devolvida!");
                }else{
                    System.out.println("Usuario deve pagar multa de R$" + usuario.getValorMulta());                    
                }
                Biblioteca.removerEmprestimo(Biblioteca.getEmprestimos()[i]);
            }
        }
    }

    public void renovacao(ItemMultimidiaImpl item){
        int qtdEmprestimos = Emprestimo.getQtdEmprestimos();
        int i;
        Emprestimo[] emprestimosBiblioteca = Biblioteca.getEmprestimos();
        for(i = 0; i < qtdEmprestimos; i++){
            if(emprestimosBiblioteca[i] != null && emprestimosBiblioteca[i].getItem() == item){
                // adicionar reserva
                LocalDate dataAntiga  = emprestimosBiblioteca[i].getDataDevolucao();
                int diasAMais = emprestimosBiblioteca[i].getEmprestante().getPrazoEmprestimo();
                LocalDate novaData = dataAntiga.plusDays(diasAMais);
                emprestimosBiblioteca[i].setDataDevolucao(novaData);
                System.out.println("Devolucao atualizada: de " + dataAntiga + " para " + novaData);
            }
        }
    }
}

