package lambdas;

import java.util.function.Predicate;

public class Predicado {

	public static void main(String[] args) {
		
		Predicate<Produto> isExpensive = prod -> prod.preco >= 750;
		Predicate<Produto> isExpensiveWithDiscount = prod -> (prod.preco * (1-prod.desconto)) >= 750;
		
		// Note que, as funções lambdas, definidas acima, aplicadas abaixo
		// reconhece os métodos residentes dentro da classe Produto
		Produto produto = new Produto("Notebook", 3893.89, 0.15);
		System.out.println(isExpensive.test(produto));
		System.out.println(isExpensiveWithDiscount.test(produto));
	}
}
