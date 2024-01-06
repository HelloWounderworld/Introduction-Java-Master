package fundamentos.operadores;

public class Ternario {

	public static void main(String[] args) {
		
		double media = 5.6;
//		String resultadoParcial = media >= 5.0 ? "em recuperacao" : "reprovado";
//		String resultadoFinal = media >= 7.0 ? "aprovado" : resultadoParcial;
		String resultadoFinal = media >= 7.0 ? "aprovado" : media >= 5.0 ? "em recuperacao" : "reprovado";
		
		System.out.println("O aluno está " + resultadoFinal);
		
		double nota = 7.3;
		boolean bomComportamento = true;
		boolean passouPorMedia = nota >= 7;
		boolean temDesconto = bomComportamento && passouPorMedia;
		
		String resultado = temDesconto ? "Sim." : "Não.";
		
		System.out.println("Tem desconto? " + temDesconto);
		System.out.println("Tem desconto? " + resultado);
		System.out.printf("Tem desconto? %s", resultado);
	}
}
