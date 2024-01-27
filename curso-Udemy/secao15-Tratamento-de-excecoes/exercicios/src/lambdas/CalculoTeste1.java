package lambdas;

import javax.annotation.processing.SupportedSourceVersion;

public class CalculoTeste1 {

	public static void main(String[] args) {
		
		Calculo soma = new Soma();
		Calculo multiplicar = new Multiplicar();
		
		System.out.println(soma.executar(1, 2));
		System.out.println(multiplicar.executar(2, 3));
		
		Calculo calculo = new Soma();
		System.out.println(calculo.executar(2, 3));
		
		calculo = new Multiplicar();
		System.out.println(calculo.executar(2, 3));
	}
}
