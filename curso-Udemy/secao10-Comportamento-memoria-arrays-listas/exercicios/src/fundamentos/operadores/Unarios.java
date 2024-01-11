package fundamentos.operadores;

public class Unarios {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		
		// For pós fixada
		a++; // a = a + 1
		a--; // a = a - 1
		
		// Forma pré-fixada
		++b; // b = b + 1
		--b; // b = b - 1
		
		System.out.println(a);
		System.out.println(b);
		
		System.out.println("Desafio - falso ou verdadeiro");
		System.out.println(++a == b--);
		System.out.println("Precedencia - Eu vi isso em Python");
		System.out.println(a == b);
		System.out.println(a);
		System.out.println(b);
		
		// O mesmo vale para byte, short, long, float, double
		
		
	}
}
