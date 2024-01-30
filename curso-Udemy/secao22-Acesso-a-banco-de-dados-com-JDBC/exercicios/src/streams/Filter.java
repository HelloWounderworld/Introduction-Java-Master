package streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Filter {

	public static void main(String[] args) {
		
		Consumer<String> printarln = System.out::println;
		
		Aluno a1 = new Aluno("Ana", 7.8);
		Aluno a2 = new Aluno("Bianca", 9);
		Aluno a3 = new Aluno("Daniel",6);
		Aluno a4 = new Aluno("Leonardo", 10);
		Aluno a5 = new Aluno("Rebeca", 9.5);
		Aluno a6 = new Aluno("Pedro", 8.7);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6);
		
		Predicate<Aluno> estaAprovado = a -> a.nota >= 7;
		Function<Aluno, String> saudacaoAprovado = a -> "Parabéns, " + a.nome + "! Você foi aprovado!";
		
//		alunos.stream()
//			.filter(a -> a.nota >= 7)
//			.map(a -> "Parabéns, " + a.nome + "! Você foi aprovado!")
//			.forEach(System.out::println);
		
		alunos.stream()
			.filter(estaAprovado)
			.map(saudacaoAprovado)
			.forEach(printarln);
	}
}
