package br.com.mcqueide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Hello world!
 *
 */
public class Aula1 
{
    private static List<String> palavras;

	public static void main( String[] args )
    {
		palavras = new ArrayList<>();
    	palavras.add("alura online");
    	palavras.add("editora casa do codigo");
    	palavras.add("caelum");
    	
        defaultMethods();
        
        interableForEach();
    }
    
    public static void defaultMethods(){
    	Collections.sort(palavras);
    	System.out.println("Comparador por ondem alfanumérico:\n" + palavras);
    	
    	Collections.sort(palavras,new ComparadorPorTamanho());
    	System.out.println("\nComparador por tamanho de palavra:\n" + palavras);
    	
    	palavras.sort(new ComparadorPorTamanho());
    	System.out.println("\nComparador por tamanho de palavra, mas utilizando o sort da interface List:\n" + palavras);
    	
    	System.out.println("\n\n==================================\n\n");
    }
    
    public static void interableForEach(){
    	System.out.println("For each tradicional:");
    	for (String palavra : palavras) {
			System.out.print(palavra + ", ");
		}
    	
    	System.out.println("\n\nFor each da interface interable:");
    	palavras.forEach(new ImprimeNaLinha());
    }
}

class ComparadorPorTamanho implements Comparator<String>{

	@Override
	public int compare(String s1, String s2) {
		if(s1.length() < s2.length())
			return -1;
		if(s1.length() > s2.length())
			return 1;
		return 0;
	}
	
}

class ImprimeNaLinha implements Consumer<String>{

	@Override
	public void accept(String s) {
		System.out.print(s + ", ");
	}
	
}