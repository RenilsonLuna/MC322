package pessoa.funcionario;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import biblioteca.Biblioteca;
import biblioteca.multimidia.Multimidia;
import pessoa.Pessoa;


public final class Administradores extends Funcionario {
    public Administradores(String nome, String endereco, String contato, Biblioteca lib){
        super(nome, endereco, contato, lib);
    }

    // cadastrar membro
    public void cadastraUsuario(Pessoa usario, Biblioteca lib){ }

    public void reservar(Biblioteca lib,String tipo, String nomeTitulo, Pessoa usuario){ }

    public void aplicarMulta(Pessoa usuario, Multimidia item){ 
        long diasPassados = ChronoUnit.DAYS.between(item.getDataEntrega(), LocalDate.now());
        double multa = diasPassados * usuario.getValorMulta();
        System.out.println("Sr(a)"+ usuario.getNome() + "foi multado com o valor de: " + multa + " pois ficou " + diasPassados + "em atraso");
        usuario.setTotalMulta(multa);
    }

    public void reservar(Pessoa usuario, Multimidia midia){ 
        lib.AdicionarReserva(usuario, midia);
    }
 
    public void retirarMulta(Pessoa usuario){
        usuario.setTotalMulta(0.00);
    }
}
