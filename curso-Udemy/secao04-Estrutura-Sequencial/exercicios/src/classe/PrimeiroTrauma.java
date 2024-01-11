package classe;

public class PrimeiroTrauma {
	
	int a = 3; // Não pode mexer aqui
	
	// Se tivermos a variavel static
	static int b = 4;

	public static void main(String[] args) {
		
		PrimeiroTrauma teste = new PrimeiroTrauma();
		
		// pode mexer aqui
		System.out.println(teste.a);
		// pode mexer aqui
		
		// Uma outra forma de resolver - Um membro estático pode acessar um outr membro estático
		System.out.println(b);;
	}
}
