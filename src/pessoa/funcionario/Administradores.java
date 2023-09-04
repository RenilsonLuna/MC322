package pessoa.funcionario;

import java.time.LocalDate;

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

    public void aplicarMulta(Pessoa usuario, LocalDate dataDeHoje, Multimidia item){ }

    // Missing manage info
    // missing borrow
}
