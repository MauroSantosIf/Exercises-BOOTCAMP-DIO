package biblioteca.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Emprestimo {

    private final Usuario usuario;
    private final List<Livro> livros;
    private final LocalDateTime dataEmprestimo;
    private LocalDateTime dataDevolucao;
    private boolean devolvido;

    public Emprestimo(Usuario usuario, List<Livro> livros) {
        
        this.usuario = usuario;
        this.livros = List.copyOf(livros);
        this.dataEmprestimo = LocalDateTime.now();
        this.devolvido = false;
        validarRegras(usuario, livros);
        
        // marcar os livros como emprestados
        this.livros.forEach(Livro::emprestar);
        this.dataDevolucao = calcularDataDevolucao(usuario, this.dataEmprestimo); // ✅
        
    }

   private void validarRegras(Usuario usuario, List<Livro> livros) {
        int limiteLivros = (usuario instanceof Professor) ? 5 : 3;

        if (livros == null || livros.isEmpty()) {
            throw new IllegalArgumentException("A lista de livros não pode estar vazia");
        }

        if (livros.size() > limiteLivros) {
            throw new IllegalArgumentException(
                String.format("Limite de livros por empréstimo para %s é %d", usuario.getClass().getSimpleName(), limiteLivros)
            );
        }

        for (Livro livro : livros) {
            if (!livro.disponivel()) {
                throw new IllegalArgumentException("Livro " + livro.getTitulo() + " não está disponível");
            }
        }
    }

    private LocalDateTime calcularDataDevolucao(Usuario usuario, LocalDateTime dataEmprestimo) {
        int diasEmprestimo = (usuario instanceof Professor) ? 60 : 45;
        return dataEmprestimo.plusDays(diasEmprestimo);
    }


    // getters e setters
    public Usuario getUsuario() {return usuario;}

    public List<Livro> getLivros() {return livros;}

    public LocalDateTime getDataEmprestimo() {return dataEmprestimo;}

    public LocalDateTime getDataDevolucao() {return dataDevolucao;}

    public void setDataDevolucao(LocalDateTime dataDevolucao) {this.dataDevolucao = dataDevolucao;}

    public boolean isDevolvido() {return devolvido;}

    public void setDevolvido(boolean devolvido) {this.devolvido = devolvido;}

    public void registrarDevolucao() {
        this.devolvido = true;
        this.livros.forEach(Livro::devolver);
    }

    public int calcularDiasAtraso() {
    if (devolvido) {
        return 0;
    }
    
    LocalDate hoje = LocalDate.now();
    LocalDate dataDevolucaoDate = dataDevolucao.toLocalDate();
    
    return hoje.isAfter(dataDevolucaoDate) 
           ? (int) ChronoUnit.DAYS.between(dataDevolucaoDate, hoje)
           : 0;
    }

}
