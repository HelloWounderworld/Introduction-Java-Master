package lambdas;

import java.util.function.Function;

public class Funcao {

	public static void main(String[] args) {
		//      <Tipo de Parâmetro, Tipo que retorna> -> <Integer, String>, está recebendo
		// um parâmetro inteiro e está retornando uma string.
		Function<Integer, String> parOuImpar = numero -> numero % 2 == 0 ? "Par" : "Impar";
		
		System.out.println(parOuImpar.apply(33));
		System.out.println(parOuImpar.apply(24));
		
		System.out.println();
		
		Function<String, String> oResultadoE = valor -> "O resultado é: " + valor;
		Function<String, String> empolgado = valor -> valor + "!!!";
		Function<String, String> duvida = valor -> valor + "???";
		
		String resultadoFinal = parOuImpar.apply(32);
		System.out.println(resultadoFinal);
		
		System.out.println();
		
		// A lógica é a mesma que a composição de função
		// f = parOuImpar
		// g = oResultadoE
		// (g o f)(x) = g(f(x)) - mas pensa que na aplicação ele só inverte, mas, por baixo dos panos,
		// obedece a forma acima
		String resultadoFinal2 = parOuImpar.andThen(oResultadoE).apply(32);
		System.out.println(resultadoFinal2);
		
		System.out.println();
		
		String resultadoFinal3 = parOuImpar.andThen(oResultadoE).andThen(empolgado).apply(32);
		System.out.println(resultadoFinal3);
		
		System.out.println();
		
		String resultadoFinal4 = parOuImpar.andThen(oResultadoE).andThen(duvida).apply(33);
		System.out.println(resultadoFinal4);
	}
}
