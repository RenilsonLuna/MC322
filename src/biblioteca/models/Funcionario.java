package biblioteca.models;

import java.time.LocalDate;

public class Funcionario extends MembroImpl{
    
    public Funcionario(String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);

        this.multimidiasEmprestadas = new ItemMultimidiaImpl[4];
        this.prazoEmprestimo = 20;
        this.valorMulta = 0.75;
    }

    public void emprestar(ItemMultimidiaImpl item, MembroImpl usuario){
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
    
    public void devolucao(ItemMultimidiaImpl item, MembroImpl usuario){
        item.setDisponivel(true);
        LocalDate dataDeHoje = LocalDate.now();
        int qtdEmprestimos = Emprestimo.getQtdEmprestimos();
        Emprestimo[] emprestimos = lib.getEmprestimos();
        for(int i = 0; i < qtdEmprestimos; i++){
            if (emprestimos[i] != null && emprestimos[i].getItem() == item){
                if (dataDeHoje.isBefore(emprestimos[i].getDataDevolucao())){
                    System.out.println("Emprestimo " + emprestimos[i].getCodigoEmprestimo() + " desfeito. Midia devolvida!");
                }else{
                    System.out.println("Usuario deve pagar multa de R$" + usuario.getValorMulta());                    
                }
                lib.removerEmprestimo(lib.getEmprestimos()[i]);
            }
        }
    }

    public void renovacao(ItemMultimidiaImpl item){
        int qtdEmprestimos = Emprestimo.getQtdEmprestimos();
        int i;
        Emprestimo[] emprestimosLib = lib.getEmprestimos();
        for(i = 0; i < qtdEmprestimos; i++){
            if(emprestimosLib[i] != null && emprestimosLib[i].getItem() == item){
                // adicionar reserva
                LocalDate dataAntiga  = emprestimosLib[i].getDataDevolucao();
                int diasAMais = emprestimosLib[i].getEmprestante().getPrazoEmprestimo();
                LocalDate novaData = dataAntiga.plusDays(diasAMais);
                emprestimosLib[i].setDataDevolucao(novaData);
                System.out.println("Devolucao atualizada: de " + dataAntiga + " para " + novaData);
            }
        }
    }
}

