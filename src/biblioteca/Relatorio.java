package biblioteca;

import java.time.LocalDate;


public interface Relatorio {
    public String resumoAtividades(LocalDate periodo);
    public int qtdItensEmprestados();
    public int qtdItensDevolvidos();
    public Emprestimo[] emprestimosRealizados(LocalDate periodo);

    public int qtdEmprestimos();
    public int qtdReservasRealizadas();

    public String resumoMultas();

    public String disponibilidadeItens();

    public String usoPorPerfil();

    public String itensPopulares();
}
