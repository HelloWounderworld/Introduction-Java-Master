package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Map {

	public static void main(String[] args) {
		
		Consumer<String> print = System.out::print;
		
		List<String> marcas = Arrays.asList("BMW ", "Audi ", "Honda ", "Mitsubishi\n");
		marcas.stream().map(m -> m.toUpperCase()).forEach(print);
		System.out.println();
		
		// Criando operadores unários - lambda, guardando nas variaveis
		UnaryOperator<String> maiuscula = n -> n.toUpperCase();
		UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
		UnaryOperator<String> grito = n -> n + "!!!!!!";
		
		System.out.println(maiuscula.andThen(primeiraLetra).andThen(grito).apply("BMW"));
		// Usando a classe Utilitarios onde guardei as funções lambdas
		System.out.println(maiuscula.andThen(Utilitarios.primeiraLetra).andThen(Utilitarios::grito).apply("BMW"));
		System.out.println();
		
		System.out.println("Usando composição");
		marcas.stream()
			.map(maiuscula)
			.forEach(print);
		
		System.out.println();
		
		marcas.stream()
			.map(Utilitarios.maiuscula)
			.forEach(print);
		
		System.out.println();
		
		marcas.stream()
			.map(maiuscula)
			.map(primeiraLetra)
			.forEach(print);
		
		System.out.println();
		
		marcas.stream()
			.map(Utilitarios.maiuscula)
			.map(Utilitarios.primeiraLetra)
			.forEach(print);
		
		System.out.println();
		
		marcas.stream()
			.map(maiuscula)
			.map(primeiraLetra)
			.map(grito)
			.forEach(print);
		
		System.out.println();
		
		marcas.stream()
			.map(Utilitarios.maiuscula)
			.map(Utilitarios.primeiraLetra)
			.map(Utilitarios::grito)
			.forEach(print);
		
		System.out.println();
		
		// Misturando a função lambda definida nessa classe, Map, a outra em Utilidade e
		// usando a função normal da classe Utilitarios como lambda.
		marcas.stream()
			.map(maiuscula)
			.map(Utilitarios.primeiraLetra)
			.map(Utilitarios::grito)
			.forEach(print);
	}
}
