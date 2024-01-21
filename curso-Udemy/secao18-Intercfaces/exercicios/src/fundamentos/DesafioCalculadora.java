package fundamentos;

import java.util.Scanner;

public class DesafioCalculadora {

	public static void main(String[] args) {
		// Ler num1
		// Ler num2
		// + - * / %

		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Escolha o primeiro número:");
		double num1 = Double.parseDouble(entrada.next());
		
		System.out.println("Escolha a operação que deseja realizar: + - * / %");
		String operacao = entrada.next();
		
		System.out.println("Escolha o segundo número: ");
		double num2 = Double.parseDouble(entrada.next());
		
		double adiciona = operacao.equals("+") ? num1 + num2 : 0;
		double subtrai = operacao.equals("-") ? num1 - num2 : adiciona;
		double multiplica = operacao.equals("*") ? num1 * num2 : subtrai;
		double divide = operacao.equals("/") ? num1 / num2 : multiplica;
		double resultado = operacao.equals("%") ? num1 % num2 : divide;
		System.out.printf("%.2f %s %.2f = %.2f", num1, operacao, num2, resultado);
		
		entrada.close();
	}
}
