package controle;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {
		// if(...) sentença; ou {}
		// while(...) sentença; ou {}
		// for(...;...;...) sentença; ou {}
		
		// do sentença; ou {} while(...);
		
		Scanner entrada = new Scanner(System.in);
		
		String texto = "";
		
		do {
			System.out.println("Você precisa falar as palavras mágicas...");
			System.out.println("Quer sair?");
			texto = entrada.nextLine();
		} while(!texto.equalsIgnoreCase("A vara que raba!!"));
		
		System.out.println("Obrigado!");
		entrada.close();
	}
}
