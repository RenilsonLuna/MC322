package biblioteca.models;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public final class Administradores extends Funcionario {
    public Administradores(String nome, String endereco, String contato){
        super(nome, endereco, contato);
    }

    // cadastrar membro
    public void cadastraUsuario(MembroImpl usario){ }

    public void reservar(String tipo, String nomeTitulo, MembroImpl usuario){ }

    public void aplicarMulta(MembroImpl usuario, ItemMultimidiaImpl item){ 
        long diasPassados = ChronoUnit.DAYS.between(item.getDataEntrega(), LocalDate.now());
        double multa = diasPassados * usuario.getValorMulta();
        System.out.println("Sr(a)"+ usuario.getNome() + "foi multado com o valor de: " + multa + " pois ficou " + diasPassados + "em atraso");
        usuario.setTotalMulta(multa);
    }

    public void reservar(MembroImpl usuario, ItemMultimidiaImpl midia){ 
        Biblioteca.AdicionarReserva(usuario, midia);
    }
 
    public void retirarMulta(MembroImpl usuario){
        usuario.setTotalMulta(0.00);
    }
}
