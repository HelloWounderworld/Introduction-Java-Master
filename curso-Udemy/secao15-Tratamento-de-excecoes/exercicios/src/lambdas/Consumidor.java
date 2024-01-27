package lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Consumidor {

	public static void main(String[] args) {
		
		Consumer<Produto> imprimir = p -> System.out.println(p.nome + "!!!");
		
		Produto p1 = new Produto("Caneta", 12.34, 0.09);
		imprimir.accept(p1);
		
		System.out.println();
		
		Produto p2 = new Produto("Notebook", 2987.89, 0.25);
		Produto p3 = new Produto("Caderno", 19.90, 0.03);
		Produto p4 = new Produto("Borracha", 7.80, 0.18);
		Produto p5 = new Produto("Lapis", 4.39, 0.19);
		
		List<Produto> produtos = Arrays.asList(p1, p2, p3, p4, p5);
		
		produtos.forEach(imprimir);
		System.out.println();
		produtos.forEach(p -> System.out.println(p.nome));
		System.out.println();
		produtos.forEach(p -> System.out.println(p.preco));
		System.out.println();
		// Na classe, Produto, precisa ter o toString definido
		// pois no Method Reference, será passado o produto como parâmetro
		produtos.forEach(System.out::println);
	}
}
