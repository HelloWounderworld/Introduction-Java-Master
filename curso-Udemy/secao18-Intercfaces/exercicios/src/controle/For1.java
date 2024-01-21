package controle;

public class For1 {

	public static void main(String[] args) {
		
		for(int soma = 0; soma < 10; soma ++) {
			System.out.println("Bom dia!");
			System.out.printf("soma = %d\n", soma);
		}
		
		int x = 2;
		for(;x < 10;) {
			System.out.println("x = " + x);
			x++;
		}
		
		// Laço infinito
//		for(;;) {
//			System.out.println("Loop infinity! Version 1");
//		}
		
//		for(;true;) {
//			System.out.println("Loop infinity! Version 2");
//		}
	}
}
