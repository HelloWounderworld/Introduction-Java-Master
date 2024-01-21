package fundamentos;

//import java.math.BigDecimal; // Tem métodos que te permite arredondar

import javax.swing.JOptionPane;

public class ConversaoStringNumero {

	public static void main(String[] args) {
		String valor1 = JOptionPane.showInputDialog("Digite o primeiro numero"); // Vai mostrar um modal
		String valor2 = JOptionPane.showInputDialog("Digite o segundo numero");
		
		System.out.println(valor1 + valor2);
		
		// Note que, valor1 e valor2 não são numéricos, mesmo que vc digite algum número
		// Caso, vc queira realizar alguma operação aritmetica, atribuído um número
		// Será necessário realizar a conversão
		
		double numero1 = Double.parseDouble(valor1);
		double numero2 = Double.parseDouble(valor2);
		
		double soma = numero1 + numero2;
		System.out.println("Soma é " + soma);
		System.out.println("Média é " + soma / 2);
	}
}
