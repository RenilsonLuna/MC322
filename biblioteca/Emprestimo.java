package biblioteca;
import biblioteca.multimidia.Multimidia;
import biblioteca.Biblioteca;

public class Emprestimo {
    private String dataEmprestimo;
    private String dataDevolucao;
    protected String documentoEmprestante;
    protected Multimidia item;

    public Emprestimo(String dataEmprestimo, String dataDevolucao, String documentoEmprestante, Multimidia item) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
        this.documentoEmprestante = documentoEmprestante;
        this.item = item;
    }

    protected boolean itemDisponivel(Biblioteca lib, Multimidia item, String documentoEmprestante){
        
        if (lib.verificaDisponibilidade(item.getIdMultimidia())){
            // Verificando se emprestante eh membro
            String[] documentos = lib.getDocumentoMembros();
            int qtdMembros = lib.getQtdMembros();
            int i;
            System.out.println("A biblioteca possui " + qtdMembros + " membros");
            for(i = 0; i < qtdMembros; i++){
                if (documentoEmprestante.equals(documentos[i])){
                    return true;
                }
            }
        }   
        return false;
    }

    public Reserva emprestar(Biblioteca lib){
        
        if (itemDisponivel(lib, item, documentoEmprestante)){
            Reserva reserva = new Reserva(dataEmprestimo, dataDevolucao, documentoEmprestante, item);
            lib.adicionarReserva(reserva);
            System.out.println("Codigo da reserva: " + reserva.getCodigoReserva());
            return reserva;
        }
        return null;
    }

    // Getters e Setters
    public String getDataEmprestimo() {
        return dataEmprestimo;
    }

    public void setDataEmprestimo(String dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public void setDataDevolucao(String dataDevolucao){
        this.dataDevolucao = dataDevolucao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }
    
    public Multimidia getItem() {
        return item;
    }
}
