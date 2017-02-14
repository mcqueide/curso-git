package br.com.mcqueide;

import java.util.ArrayList;
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
    }
}
