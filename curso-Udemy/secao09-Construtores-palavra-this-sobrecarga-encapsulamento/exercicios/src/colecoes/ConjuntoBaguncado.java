package colecoes;

import java.util.HashSet;
import java.util.Set;

public class ConjuntoBaguncado {

	// Caso vc queira apagar as advertências/reclamações aparecendo no projeto
	// podemos usar o SuppressWarnings
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		HashSet conjunto = new HashSet();
		
		conjunto.add(1.2); // double -> Double
		conjunto.add(true); // boolean -> Boolean
		conjunto.add("Teste"); // String
		conjunto.add(1); // int -> Integer
		conjunto.add('x'); // String
		
		System.out.println("Tamanho/Cardinalidade é " + conjunto.size());
		
//		conjunto.add("teste");
//		conjunto.add("Teste");
		System.out.println("Tamanho/Cardinalidade é " + conjunto.size());
		
		System.out.println((conjunto.remove("teste"))); // devolve um booleano, para verificar se existe ou não o elemento para remover
		System.out.println((conjunto.remove("Teste")));
		System.out.println((conjunto.remove('x')));
		
		System.out.println("Tamanho/Cardinalidade é " + conjunto.size());
		
		System.out.println(conjunto.contains('x')); // x in X ?
		System.out.println(conjunto.contains(1));
		System.out.println(conjunto.contains(true));
		
		Set nums = new HashSet();
		
		nums.add(1);
		nums.add(2);
		nums.add(3);
		
		System.out.println(nums);
		System.out.println(conjunto);
		
//		conjunto.addAll(nums); // X u Y
//		System.out.println(conjunto);
		
//		conjunto.retainAll(nums); // Intersecção
//		System.out.println(conjunto);
		
		conjunto.clear(); // Torna o conjunto vazio
		System.out.println(conjunto);
	}
}
