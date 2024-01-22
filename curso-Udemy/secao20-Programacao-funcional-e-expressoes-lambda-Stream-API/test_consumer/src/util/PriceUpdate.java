package util;

import java.util.function.Consumer;

import entities.Product;

public class PriceUpdate implements Consumer<Product> {

	@Override
	public void accept(Product p) {
		// TODO Auto-generated method stub
		p.setPrice(p.getPrice() * 1.1);
	}

}
