package lambdas;

import java.util.Arrays;
import java.util.List;

public class Foreach {

	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Ana", "Bia", "Leo", "Gui");
		
		System.out.println("Forma tradicional do Foreach...");
		for(String nome: aprovados) {
			System.out.println(nome);
		}
		
		System.out.println();
		
		System.out.println("Forma tradicional do Foreach usando lambda");
		aprovados.forEach((nome) -> { System.out.println(nome + "!!!"); });
		
		System.out.println();
		// Visto que tem uma única sentença, não precisamos dessa parênteses
		aprovados.forEach(nome -> { System.out.println(nome + "!!!"); });
		
		System.out.println();
		// Visto que tem uma única sentença, não precisamos dessa parênteses
		aprovados.forEach(nome -> System.out.println(nome + "!!!"));
		
		System.out.println();
		
		System.out.println("Method Reference...");
		// Estou passando diretamente os elementos como parâmetro dentro do System.out.println
		aprovados.forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Forma tradicional do Foreach usando lambda 2");
		aprovados.forEach(nome -> meuImprimir(nome));
		
		System.out.println();
		
		System.out.println("Method Reference 2...");
		// Estou passando diretamente os elementos como parâmetro dentro do System.out.println
		aprovados.forEach(Foreach::meuImprimir);
	}
	
	static void meuImprimir(String nome) {
		System.out.println("Oi! Meu nome é " + nome);
	}
}
