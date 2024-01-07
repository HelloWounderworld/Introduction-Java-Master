package fundamentos;

public class TiposPrimitivos {

	public static void main(String[] args) {
		// Informações do funcionário
		
		// Tipos numéricos inteiros
		byte anosDeEmpresa = 23; // se colocar 128 ele dará problema
		short numeroDeVoos = 542; // se colocar acima disso dará problema
		int id = 56789;
		long pontosAcumulados = 1_234_845_223; // Se vc colocar mais que 3 bilhões dará um problema
		pontosAcumulados = 3_234_845_223L; // Você precisa colocar um L (large) caso supere os 3 bilhões
		
		// Tipos numéricos reais
		float salario = 11_445.44F;// Se vc utilizar o float, é necessário colocar o F (pode ser f) no final para indicar que é literal float, e não double
		salario = 1.22F;
		double vendasAcumuladas = 2_991_797_103.01;
		
		// Até agora, temos 6 tipos numéricos básicos.
		
		// Tipo booleano
		boolean estaDeFerias = false; // true
		
		// Tipo caractere
		char status = 'A'; // ativo - Vc pode colocar um tipo de caractere, não pode colocar, por exemplo, 'AT'
//		char statusDois = '\u0010'; // raras excecoes, vc pode colocar esse tipo de dado que é um tipo de valor da tabela unicode
		
		// Dias de empresas
		System.out.println(anosDeEmpresa * 365);
		
		// Número de viagens
		System.out.println(numeroDeVoos / 2);
		
		// Pontos por real
		System.out.println(pontosAcumulados / vendasAcumuladas);
		
		System.out.println(id + ": ganha -> " + salario);
		System.out.println("Férias? " + estaDeFerias);
		
		System.out.println("Status: " + status);
	}
}
