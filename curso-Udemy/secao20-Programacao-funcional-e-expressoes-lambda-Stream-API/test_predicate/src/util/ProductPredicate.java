package util;

import java.util.function.Predicate;

import entities.Product;

public class ProductPredicate implements Predicate<Product> {

	// Método test, conforme foi mostrado na sintaxe
	@Override
	public boolean test(Product p) {
		// TODO Auto-generated method stub
		return p.getPrice() >= 100.0;
	}

}
