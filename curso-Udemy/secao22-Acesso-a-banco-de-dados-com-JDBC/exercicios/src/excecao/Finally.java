package excecao;

import java.util.Scanner;

public class Finally {

	public static void main(String[] args) {
		
		Scanner entrada = new Scanner(System.in);
		
		try {
			System.out.println(7 / entrada.nextInt());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Finalmente #01...");
			entrada.close();
		}
		
		// Mesmo que o erro que estiver dando não estivar mapeado nos catchs
//		try {
//			System.out.println(7 / entrada.nextInt());
//		} catch (OutOfMemoryError e) {
//			System.out.println(e.getMessage());
//		} finally {
//			System.out.println("Finalmente #02...");
//			entrada.close();
//		}
		
		// Não precisa ter o catch, tanto para o uso do try quanto do finally.
		// Mas para ter o finally, tem que ter o try
//		try {
//			System.out.println(7 / entrada.nextInt());
//		} finally {
//			System.out.println("Finalmente #03...");
//			entrada.close();
//		}
		
		System.out.println("Fim :)");
	}
}
