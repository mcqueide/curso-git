package br.com.mcqueide;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Aula3 {
	
	private static List<String> palavras;
	
	public static void main(String[] args) {
		palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caelum");

		comparatorDefaultMethods();

		comparatorDefaultMethodsLambda();

		comparatorDefaultMethodsWithMethodReference();
	}

	private static void comparatorDefaultMethods() {
		Function function = new Function<String, Integer>() {
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};

		Comparator comparator = Comparator.comparing(function);

		palavras.sort(comparator);
	}

	private static void comparatorDefaultMethodsLambda(){
		palavras.sort(Comparator.comparing(s -> s.length()));
	}

	private static void comparatorDefaultMethodsWithMethodReference(){
		palavras.sort(Comparator.comparing(String::length));
	}

}
