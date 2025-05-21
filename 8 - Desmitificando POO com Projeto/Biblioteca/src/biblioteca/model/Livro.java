package biblioteca.model;

import java.util.Objects;

/**
 * Classe que representa um livro na biblioteca.
 * 
 * Atributos:
 * - isbn: Identificador único do livro (imutável).
 * - titulo: Título do livro (imutável).
 * - autor: Autor do livro (imutável).
 * - exemplaresDisponiveis: Número de exemplares disponíveis para empréstimo (mutável).
 * - totalExemplares: Total de exemplares adquiridos (imutável).
 */


public class Livro {
    private final String isbn;         
    private final String titulo;       
    private final String autor;       
    private int exemplaresDisponiveis;
    private int totalExemplares;     


    public Livro(String isbn, String titulo, String autor, int totalExemplares) {
        if (totalExemplares <= 0) {
            throw new IllegalArgumentException("Total de exemplares deve ser positivo");
        }
        
        this.isbn = Objects.requireNonNull(isbn, "ISBN não pode ser nulo");
        this.titulo = Objects.requireNonNull(titulo, "Título não pode ser nulo");
        this.autor = Objects.requireNonNull(autor, "Autor não pode ser nulo");
        this.totalExemplares = totalExemplares;
        this.exemplaresDisponiveis = totalExemplares;
    }

    // Métodos de negócio
    public void emprestar() {
        if (!disponivel()) {
            throw new IllegalStateException("Não há exemplares disponíveis para empréstimo");
        }
        exemplaresDisponiveis--;
    }

    public void devolver() {
        if (exemplaresDisponiveis >= totalExemplares) {
            throw new IllegalStateException("Todos os exemplares já foram devolvidos");
        }
        exemplaresDisponiveis++;
    }

    // Método de consulta
    public boolean disponivel() {
        return exemplaresDisponiveis > 0;
    }

    // Getters (sem setters para atributos imutáveis)
    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public int getTotalExemplares() {
        return totalExemplares;
    }

    // Métodos sobrescritos (override)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return isbn.equals(livro.isbn); // ISBN como identificador único
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return "\nLivro\n" +
           "----------------------------\n" +
           "ISBN:       " + isbn + "\n" +
           "Título:     " + titulo + "\n" +
           "Autor:      " + autor + "\n" +
           "Disponível: " + exemplaresDisponiveis + " de " + totalExemplares + "\n" +
           "----------------------------";
    }
}
