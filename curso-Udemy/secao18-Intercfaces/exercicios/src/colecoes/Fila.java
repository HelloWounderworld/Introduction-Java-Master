package colecoes;

import java.util.LinkedList;
import java.util.Queue;

public class Fila {

	public static void main(String[] args) {
		
		Queue<String> fila = new LinkedList<>();
		
		// Offer e Add -> Adiciona elementos na fila
		// Diferença é o comportamento quando a fila está cheia:
		fila.add("Ana"); // Add - Lança uma exceção
		fila.offer("Bia"); // Offer - retorna false
		fila.add("Carlos");
		fila.offer("Daniel");
		fila.add("Rafaela");
		fila.offer("Gui");
		
		// Peek e Element - Obtem o próximo elemento da fila sem removê-la
		// A diferença dos dois é quando a fila está vazia:
		// Peek - returna null
		// Element - retorna um erro parando a compilação
		System.out.println(fila.peek()); // Apenas lê o primeiro elemento da fila
		System.out.println(fila.peek());
		System.out.println(fila.element());
		System.out.println(fila.element());
		
//		fila.size();
//		fila.clear();
//		fila.isEmpty();
		
		// Remove os elementos pela primeira
		// Se a fila estiver vazia o poll retorna null
		// Poll e Remove - ambas removem os elementos da fila pegando a partir da primeira
		// A diferença está quando a fila fica vazia:
		// Poll - lança um null
		// Remove - lança uma exceção
		System.out.println(fila.poll());
		System.out.println(fila.remove());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
		System.out.println(fila.poll());
	}
}
