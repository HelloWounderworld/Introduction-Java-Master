package fundamentos;

import java.util.Locale;
import java.util.Scanner;

public class DesafioScanner {

	public static void main(String[] args) {
		Scanner salario = new Scanner(System.in);
		
		Locale.setDefault(new Locale("en", "US"));
		
		System.out.print("Digite o salário do funcionário1: ");
		String salario1 = salario.nextLine().replace(",", ".");
		
		System.out.print("Digite o salário do funcionário2: ");
		String salario2 = salario.nextLine().replace(",", ".");
		
		System.out.print("Digite o salário do funcionário3: ");
		String salario3 = salario.nextLine().replace(",", ".");
		
		double numero1 = Double.parseDouble(salario1);
		double numero2 = Double.parseDouble(salario2);
		double numero3 = Double.parseDouble(salario3);
		
		double soma = numero1 + numero2 + numero3;
		double media = soma / 3;
		
		System.out.println("A média do salário é " + media);
		
		salario.close();
	}
}
