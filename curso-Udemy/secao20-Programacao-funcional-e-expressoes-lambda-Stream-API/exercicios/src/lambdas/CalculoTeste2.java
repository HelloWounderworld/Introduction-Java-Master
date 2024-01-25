package lambdas;

public class CalculoTeste2 {

	public static void main(String[] args) {
		
//		Calculo calculo = (x, y) -> {
//			return x + y;
//		};
		
		Calculo calculo = (x, y) -> { return x + y; };
		System.out.println(calculo.executar(2, 3));
		
//		calculo = (x, y) -> { return x * y; };
		calculo = (x, y) -> x * y;
		System.out.println(calculo.executar(2, 3));
		
		System.out.println(calculo.legal());
		
		// Maneira de acessar método estático
		System.out.println(Calculo.muitoLegal());
	}
}
