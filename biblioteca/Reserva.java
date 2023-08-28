package biblioteca;
import biblioteca.multimidia.Multimidia;

public class Reserva extends Emprestimo {
    private int codigoReserva;

    public Reserva(String dataEmprestimo, String dataDevolucao, String documentoEmprestante, Multimidia item) {
        super(dataEmprestimo, dataDevolucao, documentoEmprestante, item);
        
        this.codigoReserva = item.getIdMultimidia();
    }

    protected void renovarReserva(String novaData){
        setDataDevolucao(novaData);
    }

    // Getter
    public int getCodigoReserva() {
        return codigoReserva;
    }

}
