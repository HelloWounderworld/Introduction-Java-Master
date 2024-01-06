package controle;

public class ContinueRotulado {

	public static void main(String[] args) {
		
		// Aqui o break só funciona para o último bloco, que é o for interno
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (i == 1) {
					continue;
				}
				
				System.out.printf("[%d %d]", i, j);
			}
			System.out.println();
		}
		
		// rotulando, para caso ocorra o break, ela pare todos os for e saia dela
		externo: for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (i == 1) {
					continue externo;
				}
				
				System.out.printf("[%d %d]", i, j);
			}
			System.out.println();
		}
		
		System.out.println("Fim!");
		
		externo:
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if (i == 1) {
					continue externo;
				}
				
				System.out.printf("[%d %d]", i, j);
			}
			System.out.println();
		}
		
		System.out.println("Fim!");
		
		// É recomendável que não faça tanto o uso desse rótulo
	}
}
