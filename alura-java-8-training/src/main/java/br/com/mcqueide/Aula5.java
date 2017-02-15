package br.com.mcqueide;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by mcqueide on 15/02/17.
 */
public class Aula5 {

    public static List<Curso> cursos = new ArrayList<Curso>();

    public static void main(String[] args) {
        cursos.add(new Curso("Python", 45));
        cursos.add(new Curso("JavaScript", 150));
        cursos.add(new Curso("Java 8", 113));
        cursos.add(new Curso("C", 55));

        encontraQualquerCursoEm(cursos);

        geraListaApartiDeStream(cursos);
    }

    private static void encontraQualquerCursoEm(List<Curso> cursos) {

        //apenas obtem o objeto sem tratar se é nulo ou não
        //cursos.stream().findAny().get();

        //se não achar nenhum devolve o que está no argumento
        //cursos.stream().findAny().orElse(null);

        //trata quando objeto for nulo
        cursos.stream().findAny().ifPresent(curso -> System.out.println(curso.getNome()));
    }

    private static void geraListaApartiDeStream(List<Curso> cursos) {
        List<Curso> listCursos = cursos.stream().filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toList());

        System.out.println("\nLista os cursos com mais de 100 alunos da nova lista gerada");
        listCursos.forEach(c -> System.out.println(c.getNome()));


        Map<String, Integer> mapCursos = cursos.stream().filter(c -> c.getAlunos() < 100)
                .collect(Collectors.toMap(c -> c.getNome(), c -> c.getAlunos()));
        System.out.println("\nImprime cursos e suas quantidades de alunos do mapa gerado do stream");
        mapCursos.forEach((nome,alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));
    }
}
