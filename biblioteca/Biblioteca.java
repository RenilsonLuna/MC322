package biblioteca;

import biblioteca.multimidia.Livro;
import biblioteca.Reserva;
import biblioteca.multimidia.Multimidia;

public class Biblioteca {

    private String nome;
    private String cnpj;
    private Livro[] livros = new Livro[1000000];
    private int qtdLivros = 0;
    private String[] documentoMembros = new String[1000000];
    private int qtdMembros = 0;
    private Reserva[] reservas = new Reserva[1000000];;
    private int qtdReservas = 0;

    public Biblioteca(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
    }

    // Getters
    public String getNome(){
        return nome;
    }

    public String getCnpj(){
        return cnpj;
    }

    public int getQtdLivros(){
        return qtdLivros;
    }

    public Livro[] getLivros(){
        return livros;
    }

    protected int getQtdMembros(){
        return qtdMembros;
    }
    
    protected String[] getDocumentoMembros(){
        return documentoMembros;
    } 

    protected int getQtdReservas(){
        return qtdReservas;
    }


    private Reserva[] getReservas(){
        return reservas;
    }

    // Setters
    public void setQtdLivros(int qtd){
        this.qtdLivros = qtd;
    }
    

    protected void setQtdMembros(int qtd){
        this.qtdMembros = qtd;
    }

    public void setQtdReservas(int qtdReservas) {
        this.qtdReservas = qtdReservas;
    }


    // Outros Metodos
    public boolean verificaDisponibilidade(int codigoMultimidia){
        if (this.getQtdLivros() == 0){
            return false;
        }

        Livro[] l = this.getLivros();

        int fim;
        if (this.getQtdLivros() == 1){
            fim = 1;
        }else{
            fim = this.getQtdLivros() - 1;
        }
        for (int i = 0; i < fim; i++){
            if (codigoMultimidia == l[i].getIdMultimidia()){
                return true;
            }
        }
        return false;
    }


    public void adicionarLivro(Livro livro){
        int n_livros = getQtdLivros();
        if (n_livros == 0){
            livros[0] = livro;
        }else{
            livros[n_livros-1] = livro;
        }
        setQtdLivros(n_livros+1);
        System.out.println(livro.getTitulo() + " adicionado! Agora a Lib possui " + getQtdLivros() + " Livros");
    }

    public void removerLivro(int tombo){
        int n_livros = getQtdLivros();
        for (int i = 0; i < n_livros; i++){
            int t = livros[i].getTombo();

            // Se achar o livro, troca o livro com o ultimo livro da fila e reduz qtd de livros 
            // na pratica, torna posicao do livro no vetor inacessivel, pois um livro qualquer l ∈ [0, qtdLivros-1]
            if (t == tombo){
                Livro tmp = livros[i];
                livros[i] = livros[n_livros-1];
                livros[n_livros-1] = tmp;
                setQtdLivros(n_livros-1);
                System.out.println(tmp.getTitulo() + " Removido. Agora a biblioteca possui " + getQtdLivros() + " livros.");
                return;
            }
        }
        System.out.println("Livro nao encontrado!");
    }

    public void cadastrarMembro(String documento){
        int n_membros = getQtdMembros();
        if (n_membros == 0){
            documentoMembros[0] = documento;
        }else{
            documentoMembros[n_membros-1] = documento;
        }
        n_membros += 1;
        setQtdMembros(n_membros);
    }

    public void adicionarReserva(Reserva rs){
        int n_reservas = getQtdReservas();
        if (n_reservas == 0){
            reservas[0] = rs;
        }else{
            reservas[n_reservas-1] = rs;
        }
        n_reservas += 1;
        setQtdReservas(n_reservas);

        System.out.println("Reserva de '" + rs.getItem().getTitulo() + "' Feita");
    }

    public void removerReserva(int CodigoReserva){

        int n_reservas = this.getQtdReservas();
        int fim;
        if (n_reservas == 1){
            fim = 1;
        }else{
            fim = n_reservas - 1;
        }

        for (int i = 0; i < fim; i++){
            int codigo = reservas[i].getCodigoReserva();
            System.out.println(CodigoReserva);
            // Se achar a reserva, troca a reserva com a ultimo reserva da fila e reduz qtd de reservas 
            // na pratica, torna posicao da reserva no vetor inacessivel, pois uma reserva qualquer r ∈ [0, qtdReservas-1]
            if (codigo == CodigoReserva){
                Reserva tmp = reservas[i];
                reservas[i] = reservas[n_reservas-1];
                reservas[n_reservas-1] = tmp;
                this.setQtdReservas(n_reservas-1);
                System.out.println("Reserva " + tmp.getCodigoReserva() + " Removida.");
                return;
            }
        }
    }
}
