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

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso);

        Dev devMauro = new Dev();
        devMauro.setNome("Mauro");
        devMauro.inscreverBootcamp(bootcamp);
        System.out.println("Conteudo inscritos "+ devMauro.getConteudosInscritos());
        System.out.println("----------------------------------------------");
        devMauro.progredir();
       
        System.out.println("Conteudo inscritos "+ devMauro.getConteudosInscritos());


    }
}
