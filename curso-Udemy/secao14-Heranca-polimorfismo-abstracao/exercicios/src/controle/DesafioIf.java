package controle;

public class DesafioIf {

	public static void main(String[] args) {
		
		double nota = 1.3;
		
//		if (nota >= 9.0); // O problema era o ponto e vírgula que é considerado como sentença válida
		// Não usar ; em estruturas de controle (tem uma exceção)
		if (nota >= 9.0) {
			System.out.println("Quadro de Honra!");
			System.out.println("Você é fera!");
		}
	}
}
