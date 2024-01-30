package generics;

public class CaixaObjetoTeste {

	public static void main(String[] args) {
		
		CaixaObjeto caixaA = new CaixaObjeto();
		caixaA.aguardar(2.3); // double -> Double (processo chamado AutoBox)
		
		// Dará problema de Cast
//		Integer coisa = (Integer) caixaA.abrir();
		
		// Corrigindo o cast explícito
		Double coisaA = (Double) caixaA.abrir();
		System.out.println(coisaA);
		
		CaixaObjeto caixaB = new CaixaObjeto();
		caixaA.aguardar("Hello WounderWorld!"); // double -> Double (processo chamado AutoBox)
		
		String coisaB = (String) caixaA.abrir();
		System.out.println(coisaB);
		
		// Seria para evitar de ter que ficar toda hora colocando algum cast explícito
		// ou ocasionando alguma confusão do qual cast explícito usá-la que temos os
		// Generics para resolver esse tipo de problema.
	}
}
