/*
            Funcionário da biblioteca nao participa da herança
 */

package pessoa.membro;
import java.util.Random;

import biblioteca.Biblioteca;
import biblioteca.Emprestimo;
import biblioteca.multimidia.Multimidia;
import biblioteca.Reserva;

public class Funcionario {
    public String nome;
    public Biblioteca lib;
    public String cargo;
    int idFuncionario;
    
    public Funcionario(String nome, String cargo, Biblioteca lib){
        this.nome = nome;
        this.cargo = cargo;
        this.lib = lib;

        Random rand = new Random();
        this.idFuncionario = rand.nextInt(10000);
    }
    // Getters
    public String getNome() {
        return nome;
    }
    
    public String getCargo() {
        return cargo;
    }
    
    public int getIdFuncionario() {
        return idFuncionario;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }   

    public void realizarEmprestimo(String documento, Multimidia item) {
        Emprestimo emp = new Emprestimo("24/09/2023", "07/10/2023", documento, item);
        Reserva emprestado = emp.emprestar(this.lib);
        if(emprestado != null){
            System.out.println(item.getTitulo() + " - " + item.getAutores()[0] + " *emprestado com sucesso*");
        }else{
            System.out.println("Erro no emprestimo.");
        }
    }
}

