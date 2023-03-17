package entities;

public class Product {

	private String name;
	private Double price;

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	// Reference method com método estático
	// Lembre-se, método estático trabalha com o produto que vc passa como argumento
	public static boolean staticProductPredicate(Product p) {
		return p.getPrice() >= 100.0;
	}
	
	// Reference method com método não estático
	// Como não é estático, então não precisa passar o produto como argumento.
	// Ele trabalha com o próprio Objeto onde ele se encontra
	public boolean nonStaticProductPredicate() {
		return price >= 100.0;
	}

	// (... get / set / hashCode / equals)
	@Override
	public String toString() {
		return name + ", " + price;
	}
}
