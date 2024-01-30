package streams;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class ImprimindoObjetos {

	public static void main(String[] args) {
		
		List<String> aprovados = Arrays.asList("Lucas", "Leonardo", "João", "Ana");
		
		for (int i = 0; i < aprovados.size(); i++) {
			System.out.println(aprovados.get(i));
		}
		
		System.out.println();
		
		System.out.println("Usando foreach");
		for(String nome: aprovados) {
			System.out.println(nome);
		}
		
		System.out.println();
		
		System.out.println("Usando iterator...");
		Iterator<String> it = aprovados.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println();
		
		// Paradigma funcional
		System.out.println("Usando stream");
		Stream<String> st = aprovados.stream();
		st.forEach(System.out::println); // Laço interno
	}
}
