package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class CriandoStreams {

	public static void main(String[] args) {
		
		// Consumer 
		Consumer<String> print = System.out::print;
		Consumer<Object> printObject = System.out::println;
		
		// Criando uma Stream de forma direto
		Stream<String> langs = Stream.of("Java ", "Python ", "JavaScript\n");
		langs.forEach(print);
		
		// Criando uma Stream a partir de um array
		String[] maisLangs = { "Python ", "PHP ", "COBOL ", "Ruby\n" };
		Stream.of(maisLangs).forEach(print);
		
		// Criando uma Stream a partir de um array, segunda forma
		Arrays.stream(maisLangs).forEach(print);
		
		// Criando uma Stream a partir de um array, terceira forma
		Arrays.stream(maisLangs, 1, 2).forEach(print);
		Arrays.stream(maisLangs, 1, 3).forEach(print);
		Arrays.stream(maisLangs, 0, 2).forEach(print);
		Arrays.stream(maisLangs, 1, 4).forEach(print);
		
		// Criando uma Stream a partir de uma collection
		List<String> outrasLangs = Arrays.asList("C++ ", "Perl ", "Go\n");
		outrasLangs.stream().forEach(print);
		outrasLangs.parallelStream().forEach(print);
		
		// Stream de forma infinita
//		Stream.generate(() -> "a").forEach(print);
		
		// Uma outra forma de criar Stream de forma infinita
//		Stream.iterate(0, n -> n+1).forEach(printObject);
		
	}
}
