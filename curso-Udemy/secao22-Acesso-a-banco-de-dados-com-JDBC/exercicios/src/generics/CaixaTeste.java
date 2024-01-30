package generics;

public class CaixaTeste {

	public static void main(String[] args) {
		
		// Note que, ao instanciarmos a classe Caixa sem
		// o generics que definimos, <TIPO>, o método, aguardar,
		// especificado na classe, foi identificado como objeto
		Caixa caixaA = new Caixa();
		caixaA.aguardar("Hello WounderWorld!");
		
		String coisaA = (String) caixaA.abrir();
		System.out.println(coisaA);
		
		System.out.println();
		
		// Agora que, definimos o tipo de Generic para a classe instanciada
		// note que, o método, aguardar, que estamos chamando, está identificando
		// o tipo que definimos para essa classe genérica, String.
		// Disso, não irei passar nenhum outro tipo de valor, a não ser o que foi declarado
		// como String
		Caixa<String> caixaB = new Caixa<>();
		caixaB.aguardar("Hello WounderWorld! Defined generics as String!!");
		System.out.println(caixaB.abrir());
		
		String coisaB = caixaB.abrir();
		System.out.println(coisaB);
		
		System.out.println();
		
		Caixa<Double> caixaC = new Caixa<>();
		caixaC.aguardar(10.0);
		System.out.println(caixaC.abrir());
		
		Double coisaC = caixaC.abrir();
		System.out.println(coisaC);
		
	}
}
