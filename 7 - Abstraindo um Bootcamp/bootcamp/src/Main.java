import java.time.LocalDate;

import br.com.dio.desafio.dominio.*;


public class Main {
    public static void main(String[] args) {

        Curso curso = new Curso();
        Mentoria mentoria = new Mentoria();

        curso.setTitulo("Java Spring Boot");
        curso.setCargaHoraria(2);
        curso.setDescricao("Aqui, aprenderemos a mexer com Spring boot");

        mentoria.setTitulo("Mentoria Java");
        mentoria.setDescricao("descrição mentoria java");
        mentoria.setData(LocalDate.now());

        

        System.out.println(mentoria);
        System.out.println(curso);

    }
}
