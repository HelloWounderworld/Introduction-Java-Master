package lambdas;

import java.util.function.BinaryOperator;

public class CalculoTeste3 {

	public static void main(String[] args) {
			
//		Calculo calculo = (x, y) -> {
//			return x + y;
//		};
		
//			Calculo calculo = (x, y) -> { return x + y; };
		BinaryOperator<Double> calculo = (x, y) -> { return x + y; };
//		System.out.println(calculo.executar(2, 3));
		// O Java não consegue converter o tipo int para Double primitivo automaticamente.
		// Mas é possível que double -> Double
//		Double a = 1; // Note que, estou colocando um int em um primitivo Double, mas não é feito a conversão automática, como acontece quando usamos double
//		Double a = 1.0; // double -> Double
		System.out.println(calculo.apply(2.0, 3.0));
		
//		calculo = (x, y) -> { return x * y; };
		calculo = (x, y) -> x * y;
//		System.out.println(calculo.executar(2, 3));
		System.out.println(calculo.apply(2.0, 3.0));
		
		BinaryOperator<Integer> calculo2 = (x, y) -> { return x + y; };
		System.out.println(calculo2.apply(2, 3));
		
		calculo2 = (x, y) -> x * y;
		System.out.println(calculo2.apply(2, 3));
	}
}
