package streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinMax {

	public static void main(String[] args) {
		Aluno a1 = new Aluno("Ana", 7.1);
		Aluno a2 = new Aluno("Luna", 6.1);
		Aluno a3 = new Aluno("Gui", 8.7);
		Aluno a4 = new Aluno("Gabi", 9.7);
		
		List<Aluno> alunos = Arrays.asList(a1, a2, a3, a4);
		
//		Comparator<Aluno> melhorNota = new Comparator<Aluno>() {
//			@Override
//			public int compare(Aluno a1, Aluno a2) {
//				return 0;
//			}
//		};
		
		Comparator<Aluno> melhorNota = (aluno1, aluno2) -> {
			if(aluno1.nota > aluno2.nota) return 1;
			if(aluno1.nota < aluno2.nota) return -1;
			return 0;
		};
		
		// precisa implementar o método hashcode na classe Aluno
		System.out.println(alunos.stream().max(melhorNota).get());
		System.out.println(alunos.stream().min(melhorNota).get());
	}
}
