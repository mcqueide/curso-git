package br.com.mcqueide;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by mcqueide on 14/02/17.
 */
public class Aula4 {

    public static List<Curso> cursos = new ArrayList<Curso>();

    public static void main(String[] args){
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        ordenaCursosPorQuantidadeAlunos(cursos);

        System.out.println("Ordena lista: ");
        cursos.forEach(curso -> System.out.println(curso.getNome()));

        System.out.println("\nLista Com Stream: ");
        listaComStream(cursos);

        System.out.println("\nLista com map: ");
        listaComStreamEMap(cursos);

        System.out.println("\nLista com map retornando soma de alunos de cursos com mais de 100 alunos: ");
        listaComStreamEMapSomandoTotalDeAlunosDeCursosComMaisDe100(cursos);
    }

    public static void ordenaCursosPorQuantidadeAlunos(List<Curso>cursos){
        //com lambda
        //cursos.sort(Comparator.comparingInt(c -> c.getAlunos()));
        //com method reference
        cursos.sort(Comparator.comparingInt(Curso::getAlunos));
    }

    public static void listaComStream(List<Curso> cursos){
        cursos.stream()
                .filter(curso -> curso.getAlunos() > 100)
                .forEach(c -> System.out.println(c.getNome()));
    }

    public static void listaComStreamEMap(List<Curso> cursos){
        cursos.stream()
                .filter(curso -> curso.getAlunos() > 100)
                .map(curso -> curso.getAlunos())
                .forEach(System.out::println);
    }

    public static void listaComStreamEMapSomandoTotalDeAlunosDeCursosComMaisDe100(List<Curso> cursos){
        int sum = cursos.stream()
                .filter(curso -> curso.getAlunos() > 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(sum);
    }


}
