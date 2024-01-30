package generics;

public class ParesTeste {

	public static void main(String[] args) {
		
		Pares<Integer, String> resultadoConcurso = new Pares<>();
		
		resultadoConcurso.adicionar(1, "Maria");
		resultadoConcurso.adicionar(2, "Pedro");
		resultadoConcurso.adicionar(3, "Leonardo");
		resultadoConcurso.adicionar(4, "Ana");
		resultadoConcurso.adicionar(5, "Fernanda");
		resultadoConcurso.adicionar(2, "Rebeca");
		
		System.out.println(resultadoConcurso.getValor(1));
		System.out.println(resultadoConcurso.getValor(4));
		// Note que, ele não está aceitando repetição sempre considerando o último que foi definido
		// naquele índice
		System.out.println(resultadoConcurso.getValor(2));
	}
}
