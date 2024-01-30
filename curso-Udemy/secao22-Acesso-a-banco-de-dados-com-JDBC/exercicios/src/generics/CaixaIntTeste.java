package generics;

public class CaixaIntTeste {

	public static void main(String[] args) {
		
		// Quando a classe CaixaInt
		// public class CaixaInt<X> extends Caixa<X>
//		CaixaInt<String> caixaA = new CaixaInt<>();
//		caixaA.aguardar("Hello WounderWorld! Teste!");
//		
//		String coisaA = caixaA.abrir();
//		System.out.println(coisaA);
		
		System.out.println();
		
		// Quando a classe CaixaInt
		// public class CaixaInt extends Caixa<Integer>
		CaixaInt caixaB = new CaixaInt();
		caixaB.aguardar(123);
		
		Integer coisaB = caixaB.abrir();
		System.out.println(coisaB);
	}
}
