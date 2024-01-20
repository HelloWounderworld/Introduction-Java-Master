package fundamentos.operadores;

public class Logicos {

	public static void main(String[] args) {
		
		boolean condicao1 = true;
		boolean condicao2 = 3 > 7;
		
		System.out.println(condicao1 && condicao2);
		System.out.println(condicao1 && !condicao2);
		System.out.println(condicao1 || condicao2);
		System.out.println(condicao1 ^ condicao2); // ou exclusivo, ou bla bla ou bla bla.
		System.out.println(!condicao1);
		System.out.println(!!condicao1);
		System.out.println(!condicao2);
		
		// Tabela de verdade do and
		System.out.println("Tabela de verdade AND");
		System.out.println(true && true);
		System.out.println(true && false);
		System.out.println(false && true);
		System.out.println(false && false);
		
		// Tabela de verdade do or
		System.out.println("Tablea de verdade OR");
		System.out.println(true || true);
		System.out.println(true || false);
		System.out.println(false || true);
		System.out.println(false || false);
		
		// Tabela de verdade do xor (ou exclusivo)
		System.out.println("Tabela de verdade XOR");
		System.out.println(true ^ true);
		System.out.println(true ^ false);
		System.out.println(false ^ true);
		System.out.println(false ^ false);
		
		// Tabela de verdade do xor (ou exclusivo)
		System.out.println("Tabela de verdade NOT - operador unario");
		System.out.println(!true);
		System.out.println(!false);
	}
}
