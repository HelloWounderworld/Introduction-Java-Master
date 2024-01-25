package lambdas;

@FunctionalInterface
public interface Calculo {

	double executar(double a, double b);
	// Por conta do @FunctionalInterface, só posso criar um método
//	double teste();// Note que deu problema, visto que o método executar foi definido com @FunctionalInterface
}
