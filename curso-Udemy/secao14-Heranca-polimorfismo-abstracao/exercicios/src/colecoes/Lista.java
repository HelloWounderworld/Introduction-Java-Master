package colecoes;

import java.util.ArrayList;
import java.util.List;

public class Lista {

	public static void main(String[] args) {
		
//		ArrayList<Usuario> lista = new ArrayList<>();
		List<Usuario> lista = new ArrayList<>();
		
		Usuario u1 = new Usuario("Ana");
		
		lista.add(u1);
		lista.add(new Usuario("Carlos"));
		lista.add(new Usuario("Lia"));
		lista.add(new Usuario("Bia"));
		lista.add(new Usuario("Manu"));
		
		System.out.println(lista.get(3)); // Vc consegue acessar pelo indice
		System.out.println(lista.get(3).nome);
		
		System.out.println(">>>>>> " + lista.remove(1)); // Removendo o elemento de índice 1 - Note que nem precisei chamar o toString
		System.out.println(lista.remove(new Usuario("Manu"))); // Vai devolver um verdadeiro ou falso
		
		// Note que, tais verificações de pertinencia ou até mesmo de remoção, assim como outras formas que checam algo
		// usando o construtor new, só funciona visto que tem o equals e o hashcode definido na classe Usuario
		System.out.println("Tem? " + lista.contains(new Usuario("Lia")));
		System.out.println("Tem? " + lista.contains(u1)); // Vai dar certo, mesmo sem o equals ou hashcode, pois é da mesma intancia
		
		for(Usuario u: lista) {
			System.out.println(u);
			System.out.println(u.toString());
			System.out.println(u.nome);
		}
	}
}
