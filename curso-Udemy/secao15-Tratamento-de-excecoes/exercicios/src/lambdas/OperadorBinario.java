package lambdas;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class OperadorBinario {

	public static void main(String[] args) {
		
		// f: X x X -> X, f(x1,x2)=x3.
		BinaryOperator<Double> media = (Double n1, Double n2) -> (n1 + n2) / 2;
		System.out.println(media.apply(9.8, 5.7));
		
		// f: X x Y -> Z, f(x,y)=z
//		BiFunction<Double, Double, String> resultado = (n1, n2) -> ((n1 + n2) / 2 ) >= 7 ? "Aprovado" : "Reprovado";
		// Uma outra forma
		BiFunction<Double, Double, String> resultado = (n1, n2) -> {
			double notaFinal = (n1 + n2) / 2;
			return notaFinal >= 7 ? "Aprovado" : "Reprovado";
		};
		System.out.println(resultado.apply(9.8, 5.7));
		
		Function<Double, String> conceito = m -> m >= 7 ? "Aprovado" : "Reprovado";
		System.out.println(media.andThen(conceito).apply(9.0, 10.0));
	}
}
