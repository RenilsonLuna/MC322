
public class Principal {

    public static void main(String[] args) {
        // Criando objetos de exemplo
        Usuario usuario1 = new Usuario();
        usuario1.setNome("João");
        usuario1.setBloqueado(false);
        usuario1.setNLemprestado(2);

        Livro livro1 = new Livro();
        livro1.setTitulo("Aventura Fantástica");
        livro1.setAutor("Alice Autora");
        livro1.setEmprestado(false);

        Funcionario funcionario = new Funcionario();
        funcionario.setNome("Ana");
        funcionario.setCargo("Bibliotecária");
        funcionario.setRA(12345);

        // Realizando empréstimo
        funcionario.emprestarLivro(usuario1, livro1);

        // Exemplo de chamada do método solicitarEmprestimo na classe Usuario
        usuario1.solicitarEmprestimo();
    }
}
