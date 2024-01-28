package generics;

public class CaixaNumeroTeste {

	public static void main(String[] args) {
		
		// Note que, isso não dará certo
		// pois a classe, CaixaNumero, está com uma restrição
		// de não aceitar algum valor diferente de Número
//		CaixaNumero<String> caixaA = new CaixaNumero<>();
//		caixaA.aguardar("Teste");
		
		// Note que, para os objetos do tipo primitivos de número
		// não temos nenhum problema à respeito
		CaixaNumero<Double> caixaB = new CaixaNumero<>();
		caixaB.aguardar(87.8);
		System.out.println(caixaB.abrir());
		
		CaixaNumero<Integer> caixaC = new CaixaNumero<>();
		caixaC.aguardar(123);
		System.out.println(caixaC.abrir());
	}
}
