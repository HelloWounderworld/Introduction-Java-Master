package streams;

import java.util.function.UnaryOperator;

public class Utilitarios {
	
	// Poderia, tornar essa classe Utilitarios uma interface.
	
	// Esse private aplicado ao construtor explícito
	// torna essa classe Utilitarios não instanciável.
	private Utilitarios() {
		
	}
	
	// Lambdas
	public final static UnaryOperator<String> maiuscula = n -> n.toUpperCase();
	public final static UnaryOperator<String> primeiraLetra = n -> n.charAt(0) + "";
//	public final static UnaryOperator<String> grito = n -> n + "!!!!!!";
	
	// Função normal
	public final static String grito(String n) {
		return n + "!!!";
	}
}
