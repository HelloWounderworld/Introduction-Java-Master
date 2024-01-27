package streams;

import java.util.Arrays;
import java.util.List;

public class Outros {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.7);
		Aluno a4 = new Aluno("Gabi", 9.7);
		Aluno a5 = new Aluno("Leonardo", 10);
		Aluno a6 = new Aluno("Haluca", 0.1);
		Aluno a7 = new Aluno("Felipe", 0.7);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4, a5, a6, a7);
		
		System.out.println("Distinct...");
		alunos.stream().distinct().forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("Skip/Limit");
		alunos.stream().distinct().skip(2).forEach(System.out::println);
		System.out.println();
		alunos.stream().distinct().skip(2).limit(2).forEach(System.out::println);
		
		System.out.println();
		
		System.out.println("takeWhile");
		alunos.stream().distinct().takeWhile(a -> a.nota >= 7).forEach(System.out::println);
		System.out.println();
		alunos.stream().distinct().skip(1).takeWhile(a -> a.nota >= 7).forEach(System.out::println);
		System.out.println();
		alunos.stream().distinct().skip(2).takeWhile(a -> a.nota >= 7).forEach(System.out::println);
	}
}
