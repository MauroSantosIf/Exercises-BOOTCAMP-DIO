package biblioteca;

import biblioteca.model.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando livros
        Livro livro1 = new Livro("111-AAA", "Java para Iniciantes", "João Silva", 3);
        Livro livro2 = new Livro("222-BBB", "Estrutura de Dados", "Maria Oliveira", 2);
        Livro livro3 = new Livro("333-CCC", "Algoritmos Avançados", "Carlos Sousa", 1);
        Livro livro4 = new Livro("444-DDD", "Banco de Dados", "Ana Lima", 2);
        Livro livro5 = new Livro("555-EEE", "Engenharia de Software", "Pedro Mendes", 1);

        // Criando usuários
        Usuario aluno1 = new Aluno("Lucas Almeida", "123.456.789-00", "Rua A, 123", "(82)99999-9999", "lucas@email.com", null, null);
        Usuario professor1 = new Professor("Fernanda Costa", "987.654.321-00", "Rua B, 456", "(82)98888-8888", "fernanda@email.com");

        // Emprestando livros para aluno
        try {
            List<Livro> livrosAluno = Arrays.asList(livro1, livro2, livro3); // limite para aluno = 3
            Emprestimo emprestimoAluno = new Emprestimo(aluno1, livrosAluno);
            System.out.println("Empréstimo realizado para aluno:");
            System.out.println("Livros emprestados: " + emprestimoAluno.getLivros());
            System.out.println("Data de devolução: " + emprestimoAluno.getDataDevolucao());
        } catch (Exception e) {
            System.out.println("Erro ao emprestar para aluno: " + e.getMessage());
        }

        System.out.println("--------------------------------------");

        // Emprestando livros para professor
        try {
            List<Livro> livrosProfessor = Arrays.asList(livro1, livro2, livro4, livro5); // limite para professor = 5
            Emprestimo emprestimoProfessor = new Emprestimo(professor1, livrosProfessor);
            System.out.println("Empréstimo realizado para professor:");
            System.out.println("Livros emprestados: " + emprestimoProfessor.getLivros());
            System.out.println("Data de devolução: " + emprestimoProfessor.getDataDevolucao());
        } catch (Exception e) {
            System.out.println("Erro ao emprestar para professor: " + e.getMessage());
        }

        System.out.println("--------------------------------------");

        // Tentando emprestar um livro indisponível
        try {
            // livro3 só tinha 1 exemplar e já foi emprestado
            List<Livro> tentativa = List.of(livro3);
        } catch (Exception e) {
            System.out.println("Erro ao tentar emprestar livro indisponível: " + e.getMessage());
        }

        System.out.println("--------------------------------------");

        // Tentando passar do limite de livros
        try {
            List<Livro> muitosLivros = Arrays.asList(livro1, livro2, livro3, livro4); // aluno só pode 3
            Emprestimo ultrapassouLimite = new Emprestimo(aluno1, muitosLivros);
        } catch (Exception e) {
            System.out.println("Erro ao ultrapassar limite de livros: " + e.getMessage());
        }

        System.out.println("--------------------------------------");

        // Criando e testando devolução
        try {
            Livro livroTeste = new Livro("777-ZZZ", "Testes Automatizados", "Autor X", 1);
            Usuario aluno2 = new Aluno("Joana Lima", "111.222.333-44", "Rua X", "(82)97777-7777", "joana@email.com", null, null);
            Emprestimo emprestimo = new Emprestimo(aluno2, List.of(livroTeste));

            System.out.println("Antes da devolução, disponíveis: " + livroTeste.getExemplaresDisponiveis());
            emprestimo.registrarDevolucao();
            System.out.println("Depois da devolução, disponíveis: " + livroTeste.getExemplaresDisponiveis());
        } catch (Exception e) {
            System.out.println("Erro no processo de devolução: " + e.getMessage());
        }
    }
}
