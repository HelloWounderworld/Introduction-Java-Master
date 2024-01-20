package colecoes;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ConjuntoComportado {

	public static void main(String[] args) {
		
//		Set<String> listaAprovados = new HashSet<String>(); // <String>, estou dizendo que os tipos de elementos são Strings
//		Set<String> listaAprovados = new TreeSet<>(); // Já ordena os nomes
		SortedSet<String> listaAprovados = new TreeSet<>(); // Uma outra forma de ordenar
		
//		lista.add(1.2); // Isso dará erro e a compilação irá parar aqui
		listaAprovados.add("Ana");
		listaAprovados.add("Carlos");
		listaAprovados.add("Luca");
		listaAprovados.add("Pedro");
		
		for(String candidato: listaAprovados) {
			System.out.println(candidato);
		}
		
		Set<Integer> nums = new HashSet<>(); // Parece que ele ordena automaticamente...
		
		nums.add(1);
		nums.add(2);
		nums.add(120);
		nums.add(6);
		
		for(int n: nums) {
			System.out.println(n);
		}
	}
}
