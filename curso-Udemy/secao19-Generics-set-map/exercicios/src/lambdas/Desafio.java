package lambdas;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Desafio {

	public static void main(String[] args) {
		
		Produto p = new Produto("iPad", 3235.89, 0.5);
		
		/*
		 * 1. A partir do produto calcular o preco real (com desconto)
		 * 2. Imposto Municipal: >= 2500 (8.5%)/ < 2500 (isento)
		 * 3. Frete: >= 3000 (100)/ <3000 (50)
		 * 4. Arredondar: Deixar duas casas decimais
		 * 5. Formatar: R$ 1234.56
		 */
		
		// Está dando um problema de java.lang.NumberFormatException
		Function<Produto, Double> precoComDesconto = m -> m.preco * (1 - m.desconto);
		UnaryOperator<Double> impostoMunicipal = m -> m >= 2500 ? m * 1.085 : m;
		UnaryOperator<Double> frete = m -> m >= 3000 ? m + 100 : m + 50;
		UnaryOperator<Double> arredondar = m -> Double.parseDouble(String.format("%.2f", m).replace(",", "."));
		Function<Double, String> formatar = valor -> ("R$ " + valor).replace(".", ",");
		
		String valorFinal = precoComDesconto
			.andThen(impostoMunicipal)
			.andThen(frete)
			.andThen(arredondar)
			.andThen(formatar)
			.apply(p);
		
		System.out.println(valorFinal);
	}
}
