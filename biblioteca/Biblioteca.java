package biblioteca;

import biblioteca.Livro;

public class Biblioteca {

    private String nome;
    private String cnpj;
    private Livro[] livros = new Livro[999999];
    private int qtdLivros = 0;

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


    // Setters
    public void setQtdLivros(int qtd){
        this.qtdLivros = qtd;
    }

    public Biblioteca(String nome, String cnpj){
        this.nome = nome;
        this.cnpj = cnpj;
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

}
