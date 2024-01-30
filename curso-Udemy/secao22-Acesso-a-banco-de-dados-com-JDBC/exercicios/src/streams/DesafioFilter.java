package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class DesafioFilter {

	public static void main(String[] args) {
		
		Produto p1 = new Produto("Lapis", 1.99, 0.12, 30);
		Produto p2 = new Produto("Notebook", 19980.89, 0.38, 0);
		Produto p3 = new Produto("Caderno", 19.90, 0.45, 30);
		Produto p4 = new Produto("Impressora", 500, 0.5, 30);
		Produto p5 = new Produto("iPad", 1999.98, 0.3, 0);
		Produto p6 = new Produto("Caneta", 5.69, 0.05, 30);
		Produto p7 = new Produto("Relogio", 800, 0.4, 0);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5, p6, p7);
		
		// Filter, filter e map
		Predicate<Produto> superPromocao = p -> p.desconto >= 0.3;
		Predicate<Produto> freteGratis = p -> p.valorFrete == 0;
		Predicate<Produto> produtoRelevante = p -> p.preco >= 500;
		Function<Produto, String> chamadaPromocional = p -> "Aproveite! " + p.nome + " por R$" + p.preco;
		
		produtos.stream()
			.filter(superPromocao)
			.filter(freteGratis)
			.filter(produtoRelevante)
			.map(chamadaPromocional)
			.forEach(System.out::println);
	}
}
