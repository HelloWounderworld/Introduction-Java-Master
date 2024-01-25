package lambdas;

@FunctionalInterface
public interface Calculo {

	double executar(double a, double b);
	// Por conta do @FunctionalInterface, só posso criar um método
//	double teste();// Note que deu problema, visto que o método executar foi definido com @FunctionalInterface
	
	// Mesmo que tenhamos o @FunctionalInterface, é possível sim definir um método default
	default String legal() {
		return "legal";
	}
	
	// Aqui se aplica o mesmo conceito dos métodos estáticos, de não conseguirmos acessar o this,
	// por exemplo.
	static String muitoLegal() {
		return "muito legal";
	}
}
